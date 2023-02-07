package com.example.exercises;

import com.example.domain.City;
import com.example.domain.Country;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise16 {

    // Find the cities with the minimum and the maximum population in countries.
    public List<CountryCitySummary> findMinMaxPopCitiesPerCountry(List<Country> countries) {
        return null;
    }

    public record CountryCitySummary(Country country, City minPopCity, City maxPopCity) {
    }
}
