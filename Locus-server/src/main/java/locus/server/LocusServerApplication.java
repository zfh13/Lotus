package locus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LocusServerApplication {
    public  static void main(String[] args) {
        SpringApplication.run(LocusServerApplication.class,args);
    }


}
