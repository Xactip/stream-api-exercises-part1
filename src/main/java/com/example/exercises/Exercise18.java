package com.example.exercises;

import com.example.domain.Movie;

import java.util.Collection;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise18 {

    // Find the year when the maximum number of movie is available
    public YearToMoviesCount findYearWithMaxNumberOfMovies(Collection<Movie> movies) {
        return null;
    }

    public record YearToMoviesCount(int year, long moviesCount) {
    }
}
