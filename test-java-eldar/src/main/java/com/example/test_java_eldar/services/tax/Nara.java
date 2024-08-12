package com.example.test_java_eldar.services.tax;

import com.example.test_java_eldar.models.CreditCard;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class Nara implements TaxService {

    @Override
    public Double calculateTax(CreditCard creditCard) {
        LocalDate today = LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        System.out.println("today:" + today + "dayOfMonth: " + dayOfMonth);
        return dayOfMonth*0.5;
    }

}
