package org.example.Movie;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.example.User.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UserFavoritesMovieListTest {

    private User user;
    private Movie movie1;
    private Movie movie2;
    private UserFavoritesMovieList userFavoritesMovieList;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        user = new User("John Doe", "john.doe@email.com", "password");
        movie1 = new Movie("The Shawshank Redemption", Arrays.asList("Tim Robbins", "Morgan Freeman"), "Drama", "1994-1-1", 25);
        movie2 = new Movie("The Godfather", Arrays.asList("Marlon Brando", "Al Pacino"), "Crime", "2000-12-12", 20);
        userFavoritesMovieList = new UserFavoritesMovieList(user);
    }

    @Test
    public void testAddFavoriteMovie() {
        userFavoritesMovieList.addFavoriteMovie(movie1);

        assertEquals(1, userFavoritesMovieList.getMovieList().size());
        assertTrue(userFavoritesMovieList.getMovieList().contains(movie1));
    }

    @Test
    public void testAddMultipleFavoriteMovies() {
        userFavoritesMovieList.addFavoriteMovie(movie1);
        userFavoritesMovieList.addFavoriteMovie(movie2);

        assertEquals(2, userFavoritesMovieList.getMovieList().size());
        assertTrue(userFavoritesMovieList.getMovieList().contains(movie1));
        assertTrue(userFavoritesMovieList.getMovieList().contains(movie2));
    }

    @Test
    public void testRemoveFavoriteMovie() {
        userFavoritesMovieList.addFavoriteMovie(movie1);
        userFavoritesMovieList.removeFavoriteMovie(movie1);

        assertEquals(0, userFavoritesMovieList.getMovieList().size());
        assertFalse(userFavoritesMovieList.getMovieList().contains(movie1));
    }

    @Test
    public void testRemoveNonexistentFavoriteMovie() {
        userFavoritesMovieList.addFavoriteMovie(movie1);
        userFavoritesMovieList.addFavoriteMovie(movie2);
        userFavoritesMovieList.removeFavoriteMovie(movie2);

        assertEquals(1, userFavoritesMovieList.getMovieList().size());
        assertTrue(userFavoritesMovieList.getMovieList().contains(movie1));
    }

    @Test
    public void testGetUser() {
        assertEquals(user, userFavoritesMovieList.getUser());
    }

}