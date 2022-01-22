package com.cursor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
    }

    public static void Task1() {

        CustomInterface test1 = new CustomInterface() {
            public void display() {
                System.out.println("Display using Anonymous inner class");
            }
        };
        test1.display();
        CustomInterface test2 = () -> {
            System.out.println("Display using Lambda Expression");
        };
        test2.display();
    }

    public static void Task2() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("vb@jk.com", LocalDate.of(2022, 1, 20), "ZZZ"));
        users.add(new User("rb@jk.com", LocalDate.of(2022, 1, 13), "AAA"));
        users.add(new User("vf@jk.com", LocalDate.of(2022, 1, 16), "LLL"));
        users.add(new User("sd@jk.com", LocalDate.of(2022, 1, 22), "NNN"));
        users.add(new User("ga@jk.com", LocalDate.of(2022, 1, 11), "CCC"));

        LocalDate lt = LocalDate.now().minusWeeks(1);

        users.removeIf(x -> lt.isBefore(x.loginDate));

        Map<String, List<String>> group = users.stream()
                .collect(Collectors.groupingBy(User::getTeam,
                        Collectors.mapping(User::getEmail, Collectors.toList())));
        System.out.println(group);
    }
    public static void Task3(){
        ArrayList<Movie> fantasy = new ArrayList<Movie>();
        ArrayList<Movie> drama = new ArrayList<Movie>();

        fantasy.add(new Movie(120, "fantasy"));
        fantasy.add(new Movie(130, "fantasy"));
        fantasy.add(new Movie(140, "fantasy"));
        fantasy.stream().count();

        drama.add(new Movie(125, "drama"));
        drama.add(new Movie(115, "drama"));
        drama.add(new Movie(135, "drama"));
        drama.stream().count();

        double priceSum = fantasy.stream().collect(Collectors.summarizingDouble(Movie::getPrice)).getAverage();
        System.out.println(priceSum);
        long countFantasy = fantasy.stream().count();
        System.out.println(countFantasy);

        double priceSum1 = drama.stream().collect(Collectors.summarizingDouble(Movie::getPrice)).getAverage();
        System.out.println(priceSum1);
        long countDrama = fantasy.stream().count();
        System.out.println(countDrama);
    }
}

