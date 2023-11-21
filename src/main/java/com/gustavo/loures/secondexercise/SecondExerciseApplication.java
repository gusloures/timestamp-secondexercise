package com.gustavo.loures.secondexercise;

import com.gustavo.loures.secondexercise.service.DoorsChallengeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class SecondExerciseApplication implements CommandLineRunner {

    private final DoorsChallengeService doorsChallengeService;

    @Autowired
    public SecondExerciseApplication(DoorsChallengeService doorsChallengeService) {
        this.doorsChallengeService = doorsChallengeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondExerciseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Enter an integer number: ");
        int number = scanner.nextInt();

        List<String> combinations = doorsChallengeService.calculateCombinations(number);

        combinations.forEach(log::info);
        log.info("Maximum number of combinations: " + combinations.size());

        scanner.close();
    }
}