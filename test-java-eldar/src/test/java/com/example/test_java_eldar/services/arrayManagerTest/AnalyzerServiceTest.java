package com.example.test_java_eldar.services.arrayManagerTest;

import com.example.test_java_eldar.models.Operation;
import com.example.test_java_eldar.services.AnalyzerService;
import org.junit.jupiter.api.Test;
import org.springdoc.core.service.OperationService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class AnalyzerServiceTest {

    private final AnalyzerService analyzerService = new AnalyzerService();

    @Test
    public void testValidateAmountWithAmountGreaterThanOrEqualToMax() {
        Operation operation = new Operation();
        operation.amount = new BigDecimal("999");

        Boolean result = analyzerService.validateAmount(operation);

        assertFalse(result, "Expected validateAmount to return false for amount >= 1000");
    }

    @Test
    public void testValidateAmountWithAmountlowerThanOrEqualToMax() {
        Operation operation = new Operation();
        operation.amount = new BigDecimal("1999");

        Boolean result = analyzerService.validateAmount(operation);

        assertTrue(result, "Expected validateAmount to return false for amount >= 1000");
    }

}
