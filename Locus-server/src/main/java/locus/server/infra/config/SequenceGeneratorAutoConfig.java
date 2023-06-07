package locus.server.infra.config;

import locus.server.infra.support.keygen.SequenceGenerator;
import locus.server.infra.support.keygen.SnowFlakeSequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceGeneratorAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public SequenceGenerator getSequence(@Value("1") Long workerId,
                                         @Value("1") Long machineId) {
        SnowFlakeSequenceGenerator sequenceGenerator = new SnowFlakeSequenceGenerator(workerId,machineId);
        sequenceGenerator.init();
        return sequenceGenerator;


        }

    }

