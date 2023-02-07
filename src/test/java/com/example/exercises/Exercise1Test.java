package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise1Test {

    @Test
    public void testFindMoviesCountOfEachDirector() {
        Exercise1 exercise1 = new Exercise1();
        Collection<Movie> movies = InMemoryMovieService.getInstance().findAllMovies();

        Map<String, Long> moviesCountOfEachDirector = exercise1.findMoviesCountOfEachDirector(movies);

        assertNotNull(moviesCountOfEachDirector);

        assertAll(() -> assertEquals(1, moviesCountOfEachDirector.get("Sam Taylor Wood")),
                  () -> assertEquals(1, moviesCountOfEachDirector.get("Sam Taylor Wood")),
                  () -> assertEquals(1, moviesCountOfEachDirector.get("Andy Tennant")),
                  () -> assertEquals(2, moviesCountOfEachDirector.get("Francis Ford Coppola")),
                  () -> assertEquals(2, moviesCountOfEachDirector.get("Peter Jackson")),
                  () -> assertEquals(2, moviesCountOfEachDirector.get("Wilson Yip")),
                  () -> assertEquals(2, moviesCountOfEachDirector.get("Grant Heslov")),
                  () -> assertEquals(3, moviesCountOfEachDirector.get("Billy Wilder")),
                  () -> assertEquals(3, moviesCountOfEachDirector.get("Niels Arden Oplev")),
                  () -> assertEquals(5, moviesCountOfEachDirector.get("Ki-duk Kim")));
    }
}