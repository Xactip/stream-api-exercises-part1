package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise2Test {

    @Test
    void findMostPopulatedCityPerContinent() {
        Exercise2 exercise2 = new Exercise2();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, City> mostPopulatedCities = exercise2.findMostPopulatedCityPerContinent(countries);

        assertNotNull(mostPopulatedCities);
        assertAll(() -> assertEquals(206, mostPopulatedCities.get("South America").id()),
                  () -> assertEquals(1024, mostPopulatedCities.get("Asia").id()),
                  () -> assertEquals(3580, mostPopulatedCities.get("Europe").id()),
                  () -> assertEquals(608, mostPopulatedCities.get("Africa").id()),
                  () -> assertEquals(2515, mostPopulatedCities.get("North America").id()),
                  () -> assertEquals(130, mostPopulatedCities.get("Oceania").id())
        );
    }
}