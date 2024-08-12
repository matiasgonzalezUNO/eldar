package com.example.test_java_eldar.models;

public class CreditCard {
    public String brand;
    public String number;
    public String cardHolder;
    public String expirationDate;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String info() {
        return "Tarjeta marca: " + this.getBrand() + " -numero: " + this.getNumber() +
                ". Perteneciente a " + this.getCardHolder() + " y vence en: " + this.getExpirationDate();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        CreditCard creditCard = (CreditCard) obj;
        return brand.equals(creditCard.brand) &&
                number.equals(creditCard.number) &&
                cardHolder.equals(creditCard.cardHolder) &&
                expirationDate.equals(creditCard.expirationDate);
    }

}
