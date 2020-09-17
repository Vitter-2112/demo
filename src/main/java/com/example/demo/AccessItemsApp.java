package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

public class AccessItemsApp {

    @SpringBootApplication
    public class  AccessingDataJpaApplication {

        private  final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

        public  void main(String[] args) {
            SpringApplication.run(AccessingDataJpaApplication.class);
        }

        @Bean
        public CommandLineRunner demo(ItemRepo repo) {
            return (args) -> {
                // save a few customers
                repo.save(new Item("Sneakers", "l"));
                repo.save(new Item("Jeans ", "xl"));
                repo.save(new Item("Jeans", "m"));
                repo.save(new Item("Shoes", "m"));
                repo.save(new Item("Sneakers", "s"));


                log.info("Items found with findAll():");
                log.info("-------------------------------");
                for (Item item : repo.findAll()) {
                    log.info(item.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                Item item = repo.findById(1L);
                log.info("Items found with findById(1L):");
                log.info("--------------------------------");
                log.info(item.toString());
                log.info("");

                // fetch customers by last name
                log.info("Items found with findByName('Jeans'):");
                log.info("--------------------------------------------");
                repo.findName("Jeans").forEach(Jeans -> {
                    log.info(Jeans.toString());
                });
                // for (Customer bauer : repository.findByLastName("Bauer")) {
                //  log.info(bauer.toString());
                // }
                log.info("");
            };
        }

    }
}
