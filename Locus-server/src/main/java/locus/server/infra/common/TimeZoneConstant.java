package locus.server.infra.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZoneOffset;


@Getter
@AllArgsConstructor
public enum TimeZoneConstant {

    CHINA(ZoneId.of("Asia/Shanghai"),"上海时区",ZoneOffset.of("+08:00"));

    private ZoneId zoneId;

    private String description;

    private ZoneOffset Offset;



}
