package com.example.natwestcasestudy.service.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceGeneratorTest {
    @Test
    void getNextAccount() {
        int start = SequenceGenerator.getNextAccount();
        for (int i = 1; i < 100; i++) {
            assertEquals(SequenceGenerator.getNextAccount(), start + i);
        }
    }
    
    @Test
    void getNextTransactionId() {
        int start = SequenceGenerator.getNextTransaction();
        for (int i = 1; i < 100; i++) {
            assertEquals(SequenceGenerator.getNextTransaction(), start + i);
        }
    }
}