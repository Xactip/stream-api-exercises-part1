package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Exercise7Test {

    @Test
    void findDramaAndComedyMovies() {
        Exercise7 exercise7 = new Exercise7();
        Collection<Movie> movies = InMemoryMovieService.getInstance().findAllMovies();
        int expectedSize = 10;
        List<Integer> expectedMoviesIds = List.of(25, 32, 38, 52, 54, 59, 63, 124, 174, 222);

        List<Movie> dramaAndComedyMovies = exercise7.findDramaAndComedyMovies(movies);

        assertNotNull(dramaAndComedyMovies);
        assertEquals(expectedSize, dramaAndComedyMovies.size());
        dramaAndComedyMovies.forEach(m -> assertTrue(expectedMoviesIds.contains(m.id())));
    }
}