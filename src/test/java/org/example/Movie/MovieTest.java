package org.example.Movie;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void testConstructor() {
        String title = "The Shawshank Redemption";
        List<String> cast = new ArrayList<>();
        cast.add("Tim Robbins");
        cast.add("Morgan Freeman");
        String category = "Drama";
        String releaseDate = "1994-01-01";
        Integer budget = 25;

        Movie movie = new Movie(title, cast, category, releaseDate, budget);

        assertEquals(title, movie.title());
        assertEquals(cast, movie.cast());
        assertEquals(category, movie.category());
        assertEquals(releaseDate, movie.releaseDate());
        assertEquals(budget, movie.budget());
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsNull() {
        List<String> cast = new ArrayList<>();
        cast.add("Tom Hanks");
        String category = "Comedy";
        String releaseDate = "2001-12-12";
        Integer budget = 60;

        assertThrows(IllegalArgumentException.class, () -> new Movie(null, cast, category, releaseDate, budget));
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsEmpty() {
        List<String> cast = new ArrayList<>();
        cast.add("Tom Hanks");
        String category = "Comedy";
        String releaseDate = "2001-12-12";
        Integer budget = 60;

        assertThrows(IllegalArgumentException.class, () -> new Movie("", cast, category, releaseDate, budget));
    }

    @Test
    public void shouldThrowExceptionWhenCastIsNull() {
        String title = "Cast Away";
        String category = "Adventure";
        String releaseDate = "2000-22-22";
        Integer budget = 90;

        assertThrows(IllegalArgumentException.class, () -> new Movie(title, null, category, releaseDate, budget));
    }
}