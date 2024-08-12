package com.example.test_java_eldar.controllers;

import com.example.test_java_eldar.models.CreditCard;
import com.example.test_java_eldar.models.FlowAnalysis;
import com.example.test_java_eldar.models.Operation;
import com.example.test_java_eldar.models.RequestCardEqual;
import com.example.test_java_eldar.services.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/analyzer")
public class AnalyzerController {

    @Autowired
    AnalyzerService analyzerService;

    @GetMapping("/hola")
    public String firstTest() {
        return "Hola";
    }

    @PostMapping("/analyzecredit")
    public String analyzeCreditCard(@RequestBody CreditCard creditCard) {
        return creditCard.info();
    }

    @PostMapping("/validateamount")
    public Boolean validateAmount(@RequestBody Operation operation) {
        return analyzerService.validateAmount(operation);
    }

    @PostMapping("/validateexpirationdate")
    public Boolean validateExpirationDate(@RequestBody CreditCard creditCard) {
        return analyzerService.validateExpirationDate(creditCard);
    }

    @PostMapping("/tax")
    public String calculateTax(@RequestBody CreditCard creditCard) {
        try {
            Double tax = analyzerService.calculateTax(creditCard);
            return "La tarjeta " + creditCard.getBrand().toUpperCase(Locale.ROOT) + ", tiene una tasa de: " + tax;
        } catch (RuntimeException e) {
            return e.getMessage();
        }

    }

    @PostMapping("/cardEqual")
    public String cardEqual(@RequestBody RequestCardEqual requestCardEqual) {
        Boolean isEqual = analyzerService.isCardEqual(requestCardEqual.getCreditCardFirst(), requestCardEqual.getCreditCardSecond());
        return isEqual ? "Las tarjetas son iguales" : "Las tarjetas no son iguales" ;
    }

    @PostMapping("/analyzeoperation")
    public ResponseEntity<?> analyzeOperation(@RequestBody FlowAnalysis flowAnalysis) {
        Boolean validOperation = analyzerService.analysis(flowAnalysis);

        try {
            Double tax = analyzerService.calculateTax(flowAnalysis.getCreditCard());
            String brandTax = "La tarjeta " + flowAnalysis.getCreditCard().getBrand().toUpperCase(Locale.ROOT) + ", tiene una tasa de: " + tax;

            if (validOperation) {
                return new ResponseEntity<>(brandTax + " y la operacion es valida", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Operacion no es valida", HttpStatus.BAD_REQUEST);
            }

        }  catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }




}
