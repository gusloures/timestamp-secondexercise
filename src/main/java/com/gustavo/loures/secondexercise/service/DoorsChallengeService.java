package com.gustavo.loures.secondexercise.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class DoorsChallengeService {

    public List<String> calculateCombinations(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                    .flatMap(fireDeptNumber -> IntStream.rangeClosed(1, number)
                        .boxed()
                        .flatMap(postOfficeNumber -> IntStream.rangeClosed(1, number)
                                .filter(barbershopNumber -> checkRules(fireDeptNumber, postOfficeNumber, barbershopNumber))
                                .mapToObj(barbershopNumber -> formatCombination(fireDeptNumber, postOfficeNumber, barbershopNumber))
                        )
                )
                .toList();
    }

    public boolean isPrime(int num) {
        // Less than or equal to 1 are not prime.
        if (num <= 1) return false;
        // 2 is the only even prime number
        if (num == 2) return true;
        if ((num % 2) == 0) return false;
        // Checking divisibility up to the square root, skipping even numbers, if divisible, it's not prime.
        for (var i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRules(int fireDeptNumber, int postOfficeNumber, int barbershopNumber) {
        // Ensuring uniqueness among the door numbers for each building.
        if(fireDeptNumber == postOfficeNumber || postOfficeNumber == barbershopNumber || barbershopNumber == fireDeptNumber){
            return false;
        }
        // Rule 1: Numbers of the first building's door should be odd.
        if (fireDeptNumber % 2 == 0) {
            return false;
        }
        // Rule 2: Numbers of the second building's door should be primes.
        if (!isPrime(postOfficeNumber)) {
            return false;
        }
        // Rule 3: Numbers of the third building's door should be divisible by 5.
        if (barbershopNumber % 5 != 0) {
            return false;
        }
        return true;
    }


    private String formatCombination(int fireDeptNumber, int postOfficeNumber, int barbershopNumber) {
        return "Bombeiros=" + fireDeptNumber + " Correios=" + postOfficeNumber + " Barbeiro=" + barbershopNumber;
    }
}