package fr.ocr.service_batchmail;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServiceBatchmailApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceBatchmailApplication.class, args);

    }


}
