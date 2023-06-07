package locus.server.Service;


import locus.server.infra.common.CommonConstrant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UrlMapService implements BeanFactoryAware {

    private UrlValidator urlValidator = new UrlValidator(new String[]{CommonConstrant.HTTPS_PROTOCOL,CommonConstrant.HTTP_PROTOCOL});





    private UrlMapService self;







    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        self = beanFactory.getBean(UrlMapService.class);
    }








}
