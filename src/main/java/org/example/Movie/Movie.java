package org.example.Movie;

import java.util.List;

public record Movie(String title, List<String> cast, String category, String releaseDate, Integer budget) {
    public Movie(String title, List<String> cast, String category, String releaseDate, Integer budget) {

        if (title != null && !title.trim().isEmpty())
            this.title = title;
        else
            throw new IllegalArgumentException();

        if (cast != null && !cast.isEmpty())
            this.cast = cast;
        else
            throw new IllegalArgumentException();

        if (category != null && !category.isEmpty())
            this.category = category;
        else
            throw new IllegalArgumentException();

        if (releaseDate != null && !releaseDate.trim().isEmpty())
            this.releaseDate = releaseDate;
        else
            throw new IllegalArgumentException();

        if (budget != null && !budget.toString().isEmpty())
            this.budget = budget;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Main.Movie.Main.Movie{" +
                "title='" + title + '\'' +
                ", cast=" + cast +
                ", category='" + category + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", budget=" + budget +
                '}';
    }
}
