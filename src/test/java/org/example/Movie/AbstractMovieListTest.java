package org.example.Movie;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMovieListTest {
    private AbstractMovieList movieList;

    @BeforeEach
    public void setUp() {
        movieList = new MovieList();
        movieList.movieList.addAll(Arrays.asList(
                new Movie(
                        "The Dark Knight",
                        Arrays.asList("Christian Bale", "Heath Ledger"),
                        "Action",
                        "2000-22-22",
                        35
                ),
                new Movie(
                        "The Godfather",
                        Arrays.asList("Marlon Brando", "Al Pacino"),
                        "Crime",
                        "2000-12-12",
                        20
                ),
                new Movie(
                        "The Shawshank Redemption",
                        Arrays.asList("Tim Robbins", "Morgan Freeman"),
                        "Drama",
                        "1994-1-1",
                        25
                ),
                new Movie(
                        "The Lord of the Rings: The Return of the King",
                        Arrays.asList("Elijah Wood", "Ian McKellen"),
                        "Fantasy",
                        "2001-01-01",
                        45
                ),
                new Movie(
                        "The Hobbit: An Unexpected Journey",
                        Arrays.asList("Martin Freeman", "Ian McKellen"),
                        "Fantasy",
                        "2012-12-12",
                        80
                )
        ));
    }

    @Test
    public void testGetMovieListCategory() {
        List<Movie> sortedList = movieList.getMovieList();

        assertEquals(5, sortedList.size());

        assertEquals("Action", sortedList.get(0).category());
        assertEquals("Crime", sortedList.get(1).category());
        assertEquals("Drama", sortedList.get(2).category());
        assertEquals("Fantasy", sortedList.get(3).category());
        assertEquals("Fantasy", sortedList.get(4).category());
    }

    @Test
    public void testGetMovieListSortedByCategory() {
        List<Movie> sortedList = movieList.searchByCategory("Fantasy");

        assertEquals("The Hobbit: An Unexpected Journey", sortedList.get(0).title());
        assertEquals("The Lord of the Rings: The Return of the King", sortedList.get(1).title());
    }

    @Test
    public void testSearchByTitle_FullMatch() {
        List<Movie> results = movieList.searchByTitle("The Lord of the Rings: The Return of the King");

        assertEquals(1, results.size());
        assertEquals("The Lord of the Rings: The Return of the King", results.getFirst().title());
    }

    @Test
    public void testSearchByTitle_PartialMatch() {
        List<Movie> results = movieList.searchByTitle("dark");

        assertEquals(1, results.size());
        assertEquals("The Dark Knight", results.getFirst().title());
    }

    @Test
    public void testSearchByTitle_NoMatch() {
        List<Movie> results = movieList.searchByTitle("The Alien");

        assertEquals(0, results.size());
    }

    @Test
    public void testSearchByCast_FullMatch() {
        List<Movie> results = movieList.searchByCast("Morgan Freeman");

        assertEquals(1, results.size());
        assertEquals("The Shawshank Redemption", results.getFirst().title());
    }

    @Test
    public void testSearchByCast_PartialMatch() {
        List<Movie> results = movieList.searchByCast("Bale");

        assertEquals(1, results.size());
        assertEquals("The Dark Knight", results.getFirst().title());
    }

    @Test
    public void testSearchByCast_NoMatch() {
        List<Movie> results = movieList.searchByCast("Tom Hanks");

        assertEquals(0, results.size());
    }

    @Test
    public void testSearchByCategory_FullMatch() {
        List<Movie> results = movieList.searchByCategory("Drama");

        assertEquals(1, results.size());
        assertEquals("The Shawshank Redemption", results.getFirst().title());
    }

    @Test
    public void testSearchByCategory_PartialMatch() {
        List<Movie> results = movieList.searchByCategory("cri");

        assertEquals(1, results.size());
        assertEquals("The Godfather", results.getFirst().title());
    }

    @Test
    public void testSearchByCategory_NoMatch() {
        List<Movie> results = movieList.searchByCategory("Comedy");

        assertEquals(0, results.size());
    }
}