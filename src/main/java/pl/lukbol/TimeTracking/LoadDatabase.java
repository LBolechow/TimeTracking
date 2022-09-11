package pl.lukbol.TimeTracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WorkdayRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Workday("10/09/2022")));
            log.info("Preloading " + repository.save(new Workday("11/09/2022")));
            log.info("Preloading " + repository.save(new Workday("12/09/2022")));
        };
    }

}