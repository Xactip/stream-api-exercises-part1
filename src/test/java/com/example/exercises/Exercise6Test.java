package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise6Test {

    @Test
    void getCountriesSortedByCitiesCount() {
        Exercise6 exercise6 = new Exercise6();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        List<Country> countriesSorted = exercise6.getCountriesSortedByCitiesCount(countries);

        assertNotNull(countriesSorted);
        assertAll(() -> assertEquals("CHN", countriesSorted.get(0).code()),
                  () -> assertEquals("GBR", countriesSorted.get(10).code()),
                  () -> assertEquals("CAN", countriesSorted.get(20).code()),
                  () -> assertEquals("NLD", countriesSorted.get(30).code()),
                  () -> assertEquals("UZB", countriesSorted.get(40).code()),
                  () -> assertEquals("SDN", countriesSorted.get(50).code()),
                  () -> assertEquals("PRI", countriesSorted.get(60).code()),
                  () -> assertEquals("ZMB", countriesSorted.get(70).code()),
                  () -> assertEquals("CHE", countriesSorted.get(80).code()),
                  () -> assertEquals("MDG", countriesSorted.get(90).code()),
                  () -> assertEquals("MDA", countriesSorted.get(100).code()),
                  () -> assertEquals("NER", countriesSorted.get(110).code()),
                  () -> assertEquals("LIE", countriesSorted.get(120).code()),
                  () -> assertEquals("GUM", countriesSorted.get(130).code()),
                  () -> assertEquals("LAO", countriesSorted.get(140).code()),
                  () -> assertEquals("MHL", countriesSorted.get(150).code()),
                  () -> assertEquals("GNQ", countriesSorted.get(160).code()),
                  () -> assertEquals("MLI", countriesSorted.get(170).code()),
                  () -> assertEquals("MNG", countriesSorted.get(180).code()),
                  () -> assertEquals("SLB", countriesSorted.get(190).code()),
                  () -> assertEquals("VCT", countriesSorted.get(200).code()),
                  () -> assertEquals("SPM", countriesSorted.get(210).code()),
                  () -> assertEquals("TCA", countriesSorted.get(220).code()),
                  () -> assertEquals("VIR", countriesSorted.get(230).code())
        );
    }
}