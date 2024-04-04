package org.example.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractMovieList {
    List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        movieList.sort(Comparator.comparing(movie -> movie.category().toLowerCase()));
        return movieList;
    }

    public List<Movie> searchByTitle(String title) {
        List<Movie> searchResults = new ArrayList<>();

        for (Movie movie : movieList) {
            if (movie.title().toLowerCase().contains(title.toLowerCase())) {
                searchResults.add(movie);
            }
        }

        searchResults.sort(Comparator.comparing(movie -> movie.title().toLowerCase()));

        return searchResults;
    }

    public List<Movie> searchByCast(String cast) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movieList) {
            for (String s: movie.cast()) {
                if (s.contains(cast)) {
                    searchResults.add(movie);
                }
            }
        }
        searchResults.sort(Comparator.comparing(movie -> movie.title().toLowerCase()));
        searchResults.sort(Comparator.comparing(movie -> movie.category().toLowerCase()));

        return searchResults;
    }

    public List<Movie> searchByCategory(String category) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.category().toLowerCase().contains(category.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        searchResults.sort(Comparator.comparing(movie -> movie.title().toLowerCase()));
        searchResults.sort(Comparator.comparing(movie -> movie.category().toLowerCase()));

        return searchResults;
    }
}
