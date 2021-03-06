package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initSellers(SellerRepository repository) {
        return args -> {
            log.info("Preloading "+repository.save(new Seller(0)));

        };
    }
    @Bean
    CommandLineRunner initBuyers(BuyerRepository repository){
        return args -> {
            log.info("Preloading " +repository.save(new Buyer(0)));
        };
    }
}
