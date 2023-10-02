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
            Student great= new Student(
                    "Great",
                    "gey@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 5),
                    21
            );
            Student charles= new Student(
                    "Charles",
                    "charlie@gmail.com",
                    LocalDate.of(2004, Month.DECEMBER, 5),
                    21
            );
            repository.saveAll(
                    List.of(great, charles)
            );
        };
    }
}
