package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise10Test {

    @Test
    void getRichestCountriesPerContinent() {
        Exercise10 exercise10 = new Exercise10();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, Country> richestCountriesPerContinent = exercise10.getRichestCountriesPerContinent(countries);

        assertNotNull(richestCountriesPerContinent);
        assertAll(() -> assertEquals("BRA", richestCountriesPerContinent.get("South America").code()),
                  () -> assertEquals("JPN", richestCountriesPerContinent.get("Asia").code()),
                  () -> assertEquals("DEU", richestCountriesPerContinent.get("Europe").code()),
                  () -> assertEquals("ZAF", richestCountriesPerContinent.get("Africa").code()),
                  () -> assertEquals("ATA", richestCountriesPerContinent.get("Antarctica").code()),
                  () -> assertEquals("USA", richestCountriesPerContinent.get("North America").code()),
                  () -> assertEquals("AUS", richestCountriesPerContinent.get("Oceania").code())
        );
    }
}