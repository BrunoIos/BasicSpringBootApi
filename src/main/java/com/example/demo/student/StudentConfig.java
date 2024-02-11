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
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            List<Student> students = List.of(
                    new Student(1L, "Bruno", LocalDate.of(2000, Month.JANUARY, 5), "bruno@bruno.com", 23),
                    new Student(2L, "Maria", LocalDate.of(1998, Month.MARCH, 15), "mariera@gmail.com", 24),
                    new Student(3L, "João", LocalDate.of(2002, Month.JULY, 20), "joaero@hotmail.com", 20),
                    new Student(4L, "Carla", LocalDate.of(2001, Month.NOVEMBER, 10), "carerla@yahoo.com", 21),
                    new Student(5L, "Pedro", LocalDate.of(1999, Month.MAY, 30), "pedrwfewfo@gmail.com", 25)
            );
            studentRepository.saveAll(students);
        };
    }
}

