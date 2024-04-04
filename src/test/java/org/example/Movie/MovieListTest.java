package org.example.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieListTest {

    @Test
    public void testAddMovie() {
        MovieList movieList = new MovieList();

        String title = "The Shawshank Redemption";
        List<String> cast = Arrays.asList("Tim Robbins", "Morgan Freeman");
        String category = "Drama";
        String releaseDate = "1994-01-01";
        Integer budget = 25;

        Movie movie = new Movie(title, cast, category, releaseDate, budget);
        movieList.addMovie(movie);

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(movie);

        assertEquals(expectedList, movieList.getMovieList());
    }

    @Test
    public void testGetEmptyMovieList() {
        MovieList movieList = new MovieList();

        assertEquals(0, movieList.getMovieList().size());
    }

}