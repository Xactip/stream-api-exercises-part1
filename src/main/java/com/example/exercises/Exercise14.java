package com.example.exercises;

import com.example.domain.Country;

import java.util.List;
import java.util.Map;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise14 {

    // Find the countries of each continent with the minimum and the maximum population
    public Map<String, MinMaxPopCountries> findMinMaxPopCountriesPerContinent(List<Country> countries) {
        return null;
    }

    public record MinMaxPopCountries(List<Country> min, List<Country> max) {
    }
}
