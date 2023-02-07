package com.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public record Movie(int id, String title, int year, String imdb, List<Genre> genres, List<Director> directors) {
    public Movie {
        genres = genres != null ? genres : new ArrayList<>();
        directors = directors != null ? directors : new ArrayList<>();
    }
}