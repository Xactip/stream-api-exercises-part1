package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise15Test {

    @Test
    void getCountriesOrderedByCitiesCountPerContinent() {
        Exercise15 exercise15 = new Exercise15();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, List<Country>> result = exercise15.getCountriesOrderedByCitiesCountPerContinent(countries);

        assertNotNull(result);
        assertAll(
                () -> assertNotNull(result.get("South America")),
                () -> assertEquals("BRA", result.get("South America").get(0).code()),
                () -> assertEquals("CHL", result.get("South America").get(4).code()),
                () -> assertEquals("PRY", result.get("South America").get(8).code()),
                () -> assertNotNull(result.get("Asia")),
                () -> assertEquals("CHN", result.get("Asia").get(0).code()),
                () -> assertEquals("IRQ", result.get("Asia").get(17).code()),
                () -> assertEquals("KWT", result.get("Asia").get(34).code()),
                () -> assertNotNull(result.get("Europe")),
                () -> assertEquals("RUS", result.get("Europe").get(0).code()),
                () -> assertEquals("HUN", result.get("Europe").get(15).code()),
                () -> assertEquals("IRL", result.get("Europe").get(30).code()),
                () -> assertNotNull(result.get("Africa")),
                () -> assertEquals("NGA", result.get("Africa").get(0).code()),
                () -> assertEquals("MDG", result.get("Africa").get(19).code()),
                () -> assertEquals("SWZ", result.get("Africa").get(38).code()),
                () -> assertNotNull(result.get("Antarctica")),
                () -> assertEquals("ATA", result.get("Antarctica").get(0).code()),
                () -> assertEquals("ATF", result.get("Antarctica").get(1).code()),
                () -> assertEquals("SGS", result.get("Antarctica").get(2).code()),
                () -> assertNotNull(result.get("North America")),
                () -> assertEquals("USA", result.get("North America").get(0).code()),
                () -> assertEquals("GLP", result.get("North America").get(12).code()),
                () -> assertEquals("DMA", result.get("North America").get(24).code()),
                () -> assertNotNull(result.get("Oceania")),
                () -> assertEquals("AUS", result.get("Oceania").get(0).code()),
                () -> assertEquals("FJI", result.get("Oceania").get(9).code()),
                () -> assertEquals("SLB", result.get("Oceania").get(18).code())
        );
    }
}