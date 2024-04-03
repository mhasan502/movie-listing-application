package org.example.Movie;

import java.util.ArrayList;
import org.example.User.User;

public class UserFavoritesMovieList extends AbstractMovieList {
    private final User user;

    public UserFavoritesMovieList(User user) {
        this.user = user;
        this.movieList = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void addFavoriteMovie(Movie movie) {
        movieList.add(movie);
    }

    public void removeFavoriteMovie(Movie movie) {
        movieList.remove(movie);
    }

}
