package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise13Test {

    @Test
    void findMinMaxPopCountries() {
        Exercise13 exercise13 = new Exercise13();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Exercise13.MinMaxPopCountries minMaxPopCountries = exercise13.findMinMaxPopCountries(countries);

        assertNotNull(minMaxPopCountries);
        assertAll(() -> assertEquals(List.of("ATA", "ATF", "SGS", "BVT", "UMI", "HMD", "IOT"), minMaxPopCountries.min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("CHN"), minMaxPopCountries.max().stream().map(Country::code).toList()));
    }
}