package com.example.test_java_eldar.services.arrayManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ArrayUtil {

    @Value("${array.limit}")
    private Integer arrayLimit;

    public String convertArray(String[] array) {

        if (array.length > arrayLimit) {
            throw new IllegalArgumentException("La longitud supero el limite establecido en: " + arrayLimit);
        }

        for (String elem : array) {
            if (!elem.matches("[a-zA-Z ]+")){
                throw new IllegalArgumentException("Caracter no permitodo:" + elem);
            }
        }

        return String.join(" ", array).toLowerCase();
    }

}
