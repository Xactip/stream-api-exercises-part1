package com.example.exercises;

import com.example.domain.Director;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise3Test {

    @Test
    void findGenresOfDirectorsMovies() {
        Exercise3 exercise3 = new Exercise3();
        Collection<Movie> movies = InMemoryMovieService.getInstance().findAllMovies();

        Map<Director, Map<Genre, Long>> expectedData = Map.of(
                new Director(20, "Max Fâ€žrberbâ€�ck", "nm0299621"),
                Map.of(
                        new Genre(8, "War"), 1L,
                        new Genre(2, "Drama"), 1L
                ),
                new Director(40, "Gary Yates", "nm0946750"),
                Map.of(
                        new Genre(2, "Drama"), 1L,
                        new Genre(1, "Comedy"), 1L
                ),
                new Director(60, "Rian Johnson", "nm0426059"),
                Map.of(
                        new Genre(14, "Crime"), 1L,
                        new Genre(2, "Drama"), 1L,
                        new Genre(11, "Adventure"), 1L,
                        new Genre(3, "Romance"), 1L,
                        new Genre(1, "Comedy"), 1L
                ),
                new Director(80, "Hans-Christian Schmid", "nm0772691"),
                Map.of(
                        new Genre(2, "Drama"), 1L
                ),
                new Director(100, "Michael Spierig", "nm1294961"),
                Map.of(
                        new Genre(6, "Sci-Fi"), 1L,
                        new Genre(15, "Horror"), 1L,
                        new Genre(5, "Action"), 1L,
                        new Genre(2, "Drama"), 1L,
                        new Genre(7, "Thriller"), 1L
                ),
                new Director(120, "Nicolas Gessner", "nm0004654"),
                Map.of(
                        new Genre(15, "Horror"), 1L,
                        new Genre(2, "Drama"), 1L,
                        new Genre(7, "Thriller"), 1L,
                        new Genre(4, "Mystery"), 1L
                ),
                new Director(140, "Chris Miller", "nm0588087"),
                Map.of(
                        new Genre(12, "Animation"), 1L,
                        new Genre(13, "Family"), 1L
                ),
                new Director(160, "Antoine Fuqua", "nm0298807"),
                Map.of(
                        new Genre(14, "Crime"), 1L,
                        new Genre(5, "Action"), 1L,
                        new Genre(2, "Drama"), 1L,
                        new Genre(7, "Thriller"), 1L
                ),
                new Director(180, "Michael Sucsy", "nm1302591"),
                Map.of(
                        new Genre(9, "Biography"), 1L,
                        new Genre(2, "Drama"), 1L
                ),
                new Director(200, "Nancy Meyers", "nm0583600"),
                Map.of(
                        new Genre(2, "Drama"), 1L,
                        new Genre(3, "Romance"), 1L,
                        new Genre(1, "Comedy"), 6L,
                        new Genre(4, "Mystery"), 1L
                )
        );


        Map<Director, Map<Genre, Long>> genresOfDirectorsMovies = exercise3.findGenresOfDirectorsMovies(movies);

        assertNotNull(genresOfDirectorsMovies);

        expectedData.forEach((expDirector, expGenreLongMap) -> {
            Map<Genre, Long> actualGenreLongMap = genresOfDirectorsMovies.get(expDirector);
            assertThat(actualGenreLongMap, is(expGenreLongMap));
        });
    }
}