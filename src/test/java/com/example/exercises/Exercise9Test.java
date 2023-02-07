package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Exercise9Test {

    @Test
    void sortCountriesByPopDensityDesc() {
        Exercise9 exercise9 = new Exercise9();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();
        Map<Integer, String> expectedResult = Map.of(
                0, "MAC",
                20, "PRI",
                40, "ANT",
                60, "MNP",
                80, "KIR",
                100, "TUR",
                120, "MMR",
                140, "MEX",
                160, "GNB",
                180, "CHL"
        );

        List<Country> actualResult = exercise9.sortCountriesByPopDensityDesc(countries);

        assertNotNull(actualResult);
        expectedResult.forEach((i, code) -> assertEquals(code, actualResult.get(i).code()));
    }
}