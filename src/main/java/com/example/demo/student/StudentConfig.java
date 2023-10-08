package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Students great= new Students(
                    "Great",
                    "gey@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 5)

            );
            Students charles= new Students(
                    "Charles",
                    "charlie@gmail.com",
                    LocalDate.of(2004, Month.DECEMBER, 5)

            );
            repository.saveAll(
                    List.of(great, charles)
            );
        };
    }
}
