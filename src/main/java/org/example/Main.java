package org.example;

import java.util.Collections;
import org.example.Movie.Movie;
import org.example.Movie.MovieList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MovieList movieList = new MovieList();

        movieList.addMovie(new Movie("The Shawshank Redemption", Collections.singletonList("Tim Robbins, Morgan Freeman"), "Drama", "1994-10-14", 2500000));
    }
}