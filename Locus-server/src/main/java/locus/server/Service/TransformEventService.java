package locus.server.Service;


import eu.bitwalker.useragentutils.*;
import locus.server.dao.TransformEventRecordDao;
import locus.server.infra.util.UserAgentUtils;
import locus.server.model.entity.TransformEventRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Slf4j
@Service
public class TransformEventService {

    @Autowired
    private TransformEventRecordDao transformEventRecordDao;

    @Transactional(rollbackFor = Exception.class)
    public void recordTransformEvent(TransformEventRecord record) {

        String uniqueIdentity = DigestUtils.sha1Hex(record.getClientIp() + "-" + record.getUserAgent());
        record.setUniqueIdentity(uniqueIdentity);
        record.setShortUrlDigest(DigestUtils.sha1Hex(record.getShortUrl()));
        record.setLongUrlDigest(DigestUtils.sha1Hex(record.getLongUrl()));
        try {
            URL url = new URL(record.getShortUrl());
            if(StringUtils.isNotEmpty(url.getQuery())) {
                record.setQueryParam(url.getQuery());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if(StringUtils.isNotEmpty(record.getUserAgent())) {
            UserAgent userAgent = UserAgent.parseUserAgentString(record.getUserAgent());
            OperatingSystem operatingSystem = userAgent.getOperatingSystem();
            Optional.ofNullable(operatingSystem).ifPresent(x -> {
                record.setOsType(x.getName());
                record.setOsVersion(x.getName());
                Optional.ofNullable(x.getDeviceType()).ifPresent(deviceType -> {
                    record.setDeviceType(deviceType.getName());
                    // 操作系统组别作为手机类型 - 具体的手机型号
                    if (DeviceType.MOBILE == deviceType) {
                        UserAgentUtils.UserAgentExtractResult result
                                = UserAgentUtils.X.extractSystemType(record.getUserAgent());
                        record.setPhoneType(result.getPhoneType());
                        record.setOsType(result.getSystemType());
                        record.setOsVersion(result.getSystemVersion());
                    }
                });
            });
            // 浏览器类型
            Browser browser = userAgent.getBrowser();
            Optional.ofNullable(browser).ifPresent(x -> record.setBrowserType(x.getGroup().getName()));
            // 浏览器版本
            Version browserVersion = userAgent.getBrowserVersion();
            Optional.ofNullable(browserVersion).ifPresent(x -> record.setBrowserVersion(x.getVersion()));
            transformEventRecordDao.insertSelective(record);
        }
    }













}
