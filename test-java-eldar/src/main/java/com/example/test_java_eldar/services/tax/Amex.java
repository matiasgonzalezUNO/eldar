package com.example.test_java_eldar.services.tax;

import com.example.test_java_eldar.models.CreditCard;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class Amex implements TaxService {

    @Override
    public Double calculateTax(CreditCard creditCard) {
        YearMonth now = YearMonth.now();
        int month = now.getMonthValue();
        System.out.println("YearMonth now:" + now + "YearMonth month: " + month );
        return month*0.1;
    }

}
