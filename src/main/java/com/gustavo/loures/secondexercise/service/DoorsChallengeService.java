package com.gustavo.loures.secondexercise.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class DoorsChallengeService {

    public List<String> calculateCombinations(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, number)
                        .boxed()
                        .flatMap(j -> IntStream.rangeClosed(1, number)
                                .filter(k -> meetsRules(i, j, k))
                                .mapToObj(k -> formatCombination(i, j, k))
                        )
                )
                .toList();
    }

    public boolean isPrime(int num) {
        // Less than or equal to 1 are not prime.
        if (num <= 1) {
            return false;
        }
        // Checking divisibility up to the square root: if divisible, it's not prime.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean meetsRules(int i, int j, int k) {
        // Rule 1: Numbers of the first building's door should be odd.
        boolean rule1 = i % 2 != 0;

        // Rule 2: Numbers of the second building's door should be primes.
        boolean rule2 = isPrime(j);

        // Rule 3: Numbers of the third building's door should be divisible by 5.
        boolean rule3 = k % 5 == 0;

        // Ensuring uniqueness among the door numbers for each building.
        boolean different = i != j && j != k && k != i;

        return rule1 && rule2 && rule3 && different;
    }

    private String formatCombination(int i, int j, int k) {
        return "Bombeiros=" + i + " Correios=" + j + " Barbeiro=" + k;
    }
}