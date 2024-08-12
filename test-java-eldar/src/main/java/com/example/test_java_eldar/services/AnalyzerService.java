package com.example.test_java_eldar.services;

import com.example.test_java_eldar.models.CreditCard;
import com.example.test_java_eldar.models.FlowAnalysis;
import com.example.test_java_eldar.models.Operation;
import com.example.test_java_eldar.services.tax.Amex;
import com.example.test_java_eldar.services.tax.Nara;
import com.example.test_java_eldar.services.tax.TaxService;
import com.example.test_java_eldar.services.tax.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class AnalyzerService {

    @Autowired
    Visa visa;
    @Autowired
    Nara nara;
    @Autowired
    Amex amex;

    public Boolean analysis(FlowAnalysis flowAnalysis) {
        Boolean isAmountBig = this.validateAmount(flowAnalysis.getOperation());
        Boolean validateExpirationDate = this.validateExpirationDate(flowAnalysis.getCreditCard());

        return !isAmountBig && validateExpirationDate;
    }

    public Boolean validateAmount(Operation operation) {
        BigDecimal maxAmount = new BigDecimal("1000");
        return operation.amount.compareTo(maxAmount) >= 0;
    }

    public Boolean validateExpirationDate (CreditCard creditCard) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth cardExpiry = YearMonth.parse(creditCard.expirationDate, formatter);
        YearMonth now = YearMonth.now();
        System.out.println("YearMonth now:" + now +" cardExpiry: " + cardExpiry);
        return cardExpiry.isAfter(now);
    }

    public Double calculateTax(CreditCard creditCard) {

        return switch (creditCard.getBrand().toUpperCase(Locale.ROOT)) {
            case "VISA" -> this.handle(visa, creditCard);
            case "NARA" -> this.handle(nara, creditCard);
            case "AMEX" -> this.handle(amex, creditCard);
            default -> throw new IllegalArgumentException("Invalid card type: " + creditCard.getBrand());
        };

    }

    private Double handle(TaxService brandAnalyzer, CreditCard creditCard){
        Double tax = brandAnalyzer.calculateTax(creditCard);
        if (tax < 0.3 ) {
            return 0.3;
        }
        if ( tax > 5.0) {
            return 5.0;
        }
        return tax;
    }

    public Boolean isCardEqual(CreditCard creditCardFirst, CreditCard creditCardSecond) {
        return creditCardFirst.equals(creditCardSecond);
    }
}
