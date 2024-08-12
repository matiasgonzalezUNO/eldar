package com.example.test_java_eldar.services.tax;

import com.example.test_java_eldar.models.CreditCard;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class Visa implements TaxService {

    @Override
    public Double calculateTax(CreditCard creditCard) {
        YearMonth now = YearMonth.now();
        int month = now.getMonthValue();
        int year = now.getYear();
        String yearString = String.valueOf(year);
        String lastTwoDig = yearString.substring(yearString.length() - 2);
        System.out.println("YearMonth now:" + now + "YearMonth month: " + month + "YearMonth year: " + year);
        System.out.println("lastTwoDig:" + lastTwoDig);
        int yearLastTwoDig = Integer.parseInt(lastTwoDig);
        return (double) (yearLastTwoDig/month);
    }
}
