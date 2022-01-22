package com.cursor;

import java.time.LocalDate;

public class Movie {
    double price;
    String genre;

    public Movie(double price, String genre) {
        this.price = price;
        this.genre = genre;
    }
    public double getPrice() {
        return price;

    }
}
