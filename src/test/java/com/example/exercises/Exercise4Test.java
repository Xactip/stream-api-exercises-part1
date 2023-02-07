package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Exercise4Test {

    @Test
    void findHighPopCity() {
        Exercise4 exercise4 = new Exercise4();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        City highPopCity = exercise4.findHighPopCity(countries);

        assertNotNull(highPopCity);
        assertEquals(2331, highPopCity.id());
    }
}