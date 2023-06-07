package locus.server.Service;


import locus.server.dao.CompressionCodeDao;
import locus.server.infra.common.CommonConstrant;
import locus.server.infra.support.keygen.SequenceGenerator;
import locus.server.model.entity.CompressionCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UrlMapService implements BeanFactoryAware {

    private UrlValidator urlValidator = new UrlValidator(new String[]{CommonConstrant.HTTPS_PROTOCOL,CommonConstrant.HTTP_PROTOCOL});

    @Autowired
    private CompressionCodeDao compressionCodeDao;

    @Value("100")
    private int batchSize;


    private UrlMapService self;

    private SequenceGenerator sequenceGenerator;





    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        self = beanFactory.getBean(UrlMapService.class);
    }

    private CompressionCode getAvaiableCompressionCode() {
        CompressionCode compressionCode = compressionCodeDao.getLatestAvailableCompressionCode();
        if(Objects.nonNull(compressionCode)) {
            return compressionCode;
        } else {

        }
    }

    private void generateCompressionCode() {
        for(int i=0;i<batchSize;i++) {
            long sequence = sequenceGenerator.generator();
        }

    }






}
