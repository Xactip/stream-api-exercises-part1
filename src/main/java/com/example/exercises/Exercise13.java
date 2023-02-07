package com.example.exercises;

import com.example.domain.Country;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise13 {

    // Find the countries with the minimum and the maximum population
    public MinMaxPopCountries findMinMaxPopCountries(List<Country> countries) {
        return null;
    }

    public record MinMaxPopCountries(List<Country> min, List<Country> max) {
    }

}
