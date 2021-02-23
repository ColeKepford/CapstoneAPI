package com.HailMaryAPI.HailMary.Clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ClientConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(ClientRepository repository) {
//        return args -> {
//            Client Andre = new Client("andre.colaris98@live.ca", "Andre", "Colaris",
//                    LocalDate.of(1998, 02, 25), 4034629021L,
//                    "170 douglasview rise se", "AB", "Canada", "t2z2h8",
//                    "AndreC98", "password");
//
//            Client Jacob = new Client("jacob@live.ca", "Jacob", "Johnson",
//                    LocalDate.of(1976, 02, 1), 5876548989L,
//                    "123 Street", "AB", "Canada", "t2d6hy",
//                    "JacobJ", "password");
//            repository.saveAll(List.of(Andre,Jacob));
//        };
//    }
}
