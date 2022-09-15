package pl.lukbol.TimeTracking.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lukbol.TimeTracking.models.Workday;
import pl.lukbol.TimeTracking.repositories.WorkdayRepository;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WorkdayRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Workday("2022")));
            log.info("Preloading " + repository.save(new Workday("2021")));
            log.info("Preloading " + repository.save(new Workday("2020")));
        };
    }
}