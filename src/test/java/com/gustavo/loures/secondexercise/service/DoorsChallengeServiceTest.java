package com.gustavo.loures.secondexercise.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DoorsChallengeServiceTest {
    private DoorsChallengeService doorsChallengeService;

    @BeforeEach
    public void setUp() {
        doorsChallengeService = new DoorsChallengeService();
    }

    @Test
    void testCalculateCombinationsWithNumber5() {
        int number = 5;
        List<String> expectedCombinations = List.of(
                "Bombeiros=1 Correios=2 Barbeiro=5",
                "Bombeiros=1 Correios=3 Barbeiro=5",
                "Bombeiros=3 Correios=2 Barbeiro=5"
        );

        List<String> actualCombinations = doorsChallengeService.calculateCombinations(number);

        Assertions.assertEquals(expectedCombinations.size(), actualCombinations.size());
        Assertions.assertTrue(actualCombinations.containsAll(expectedCombinations));
    }

    @Test
    void testCalculateCombinationsWithNumber8() {
        int number = 8;
        List<String> expectedCombinations = List.of(
                "Bombeiros=1 Correios=2 Barbeiro=5",
                "Bombeiros=1 Correios=3 Barbeiro=5",
                "Bombeiros=1 Correios=7 Barbeiro=5",
                "Bombeiros=3 Correios=2 Barbeiro=5",
                "Bombeiros=3 Correios=7 Barbeiro=5",
                "Bombeiros=7 Correios=2 Barbeiro=5",
                "Bombeiros=7 Correios=3 Barbeiro=5"
        );

        List<String> actualCombinations = doorsChallengeService.calculateCombinations(number);

        Assertions.assertEquals(expectedCombinations.size(), actualCombinations.size());
        Assertions.assertTrue(actualCombinations.containsAll(expectedCombinations));
    }

    @Test
    void testCalculateCombinationsWithNumber3() {
        int number = 3;
        List<String> actualCombinations = doorsChallengeService.calculateCombinations(number);

        Assertions.assertEquals(0, actualCombinations.size());
    }
}