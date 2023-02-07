package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise8Test {

    @Test
    void groupMoviesPerYear() {
        Exercise8 exercise8 = new Exercise8();
        Collection<Movie> movies = InMemoryMovieService.getInstance().findAllMovies();
        Map<Integer, List<Integer>> expectedResult = Map.of(
                1987, List.of(140),
                1993, List.of(220, 237),
                2001, List.of(120),
                2005, List.of(73, 100, 176, 245),
                2009, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 25, 26, 27, 30, 32, 33, 34, 35, 36, 37, 38, 39, 40, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 56, 58, 59, 60, 61, 62, 64, 65, 67, 69, 71, 72, 74, 75, 76, 77, 78, 80, 82, 83, 84, 87, 90, 101, 102, 103, 106, 108, 109, 110, 114, 115, 116, 118, 123, 124, 125, 126, 128, 129, 132, 133, 134, 136, 137, 142, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 161, 162, 165, 169, 170, 171, 172, 174, 178, 179, 181, 182, 183, 184, 187, 188, 189, 190, 193, 195, 196, 197, 198, 200, 206, 207, 210, 211, 212, 213, 214, 217, 228, 233, 240, 241, 243),
                1953, List.of(234),
                1968, List.of(113),
                1977, List.of(199, 203)
        );

        Map<Integer, List<Movie>> moviesPerYear = exercise8.groupMoviesPerYear(movies);

        assertNotNull(moviesPerYear);
        expectedResult.forEach((year, moviesIds) -> {
            Optional.ofNullable(moviesPerYear.get(year)).stream()
                    .flatMap(Collection::stream)
                    .map(Movie::id)
                    .forEach(id -> assertTrue(moviesIds.contains(id)));
        });
    }
}