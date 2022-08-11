package com.example.natwestcasestudy.service.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SequenceGeneratorTest {
    @Test
    void getNextAccount() {
        for (int i = 1; i < 100; i++) {
            assertEquals(SequenceGenerator.getNextAccount(), i);
        }
        assertNotEquals(SequenceGenerator.getNextAccount(), 0);
    }
    
    @Test
    void getNextTransactionId() {
        for (int i = 1; i < 100; i++) {
            assertEquals(SequenceGenerator.getNextTransaction(), i);
        }
        assertNotEquals(SequenceGenerator.getNextTransaction(), 0);
    }
}