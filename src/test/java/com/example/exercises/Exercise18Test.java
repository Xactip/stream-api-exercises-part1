package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class Exercise18Test {

    @Test
    void findYearWithMaxNumberOfMovies() {
        Exercise18 exercise18 = new Exercise18();
        Collection<Movie> movies = InMemoryMovieService.getInstance().findAllMovies();

        Exercise18.YearToMoviesCount yearToMoviesCount = exercise18.findYearWithMaxNumberOfMovies(movies);

        assertNotNull(yearToMoviesCount);
        assertEquals(2009, yearToMoviesCount.year());
        assertEquals(145, yearToMoviesCount.moviesCount());
    }
}