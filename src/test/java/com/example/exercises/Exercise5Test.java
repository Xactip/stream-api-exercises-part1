package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    @Test
    void findHighPopCapitalOfEachContinent() {
        Exercise5 exercise5 = new Exercise5();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, City> actualResult = exercise5.findHighPopCapitalOfEachContinent(countries);

        assertNotNull(actualResult);
        assertAll(() -> assertEquals(2890, actualResult.get("South America").id()),
                  () -> assertEquals(2331, actualResult.get("Asia").id()),
                  () -> assertEquals(3580, actualResult.get("Europe").id()),
                  () -> assertEquals(608, actualResult.get("Africa").id()),
                  () -> assertEquals(2515, actualResult.get("North America").id()),
                  () -> assertEquals(135, actualResult.get("Oceania").id())
        );
    }
}