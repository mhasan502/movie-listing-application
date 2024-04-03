package org.example.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieList extends AbstractMovieList {

    public MovieList() {
        this.movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movieList.add(movie);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
