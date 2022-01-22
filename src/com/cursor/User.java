package com.cursor;

import java.time.LocalDate;

public class User {
    String email;
    LocalDate loginDate;
    String team;

    public User(String email, LocalDate loginDate, String team) {
        this.email = email;
        this.loginDate = loginDate;
        this.team = team;

    }

    public String getTeam() {
        return team;

    }

    public String getEmail() {
        return email;


    }
}
