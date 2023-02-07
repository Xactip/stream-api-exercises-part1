package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise12Test {

    @Test
    void calcPopulationSummaryPerContinent() {
        Exercise12 exercise12 = new Exercise12();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, LongSummaryStatistics> popSummaryPerContinent = exercise12.calcPopSummaryPerContinent(countries);

        assertAll(() -> assertNotNull(popSummaryPerContinent.get("South America")),
                  () -> assertEquals(2000, popSummaryPerContinent.get("South America").getMin()),
                  () -> assertEquals(24698571, (int) popSummaryPerContinent.get("South America").getAverage()),
                  () -> assertEquals(170115000, popSummaryPerContinent.get("South America").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("Asia")),
                  () -> assertEquals(286000, popSummaryPerContinent.get("Asia").getMin()),
                  () -> assertEquals(72647562, (int) popSummaryPerContinent.get("Asia").getAverage()),
                  () -> assertEquals(1277558000, popSummaryPerContinent.get("Asia").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("Europe")),
                  () -> assertEquals(1000, popSummaryPerContinent.get("Europe").getMin()),
                  () -> assertEquals(15871186, (int) popSummaryPerContinent.get("Europe").getAverage()),
                  () -> assertEquals(146934000, popSummaryPerContinent.get("Europe").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("Africa")),
                  () -> assertEquals(0, popSummaryPerContinent.get("Africa").getMin()),
                  () -> assertEquals(13525431, (int) popSummaryPerContinent.get("Africa").getAverage()),
                  () -> assertEquals(111506000, popSummaryPerContinent.get("Africa").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("Antarctica")),
                  () -> assertEquals(0, popSummaryPerContinent.get("Antarctica").getMin()),
                  () -> assertEquals(0, (int) popSummaryPerContinent.get("Antarctica").getAverage()),
                  () -> assertEquals(0, popSummaryPerContinent.get("Antarctica").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("North America")),
                  () -> assertEquals(7000, popSummaryPerContinent.get("North America").getMin()),
                  () -> assertEquals(13053864, (int) popSummaryPerContinent.get("North America").getAverage()),
                  () -> assertEquals(278357000, popSummaryPerContinent.get("North America").getMax()),

                  () -> assertNotNull(popSummaryPerContinent.get("Oceania")),
                  () -> assertEquals(0, popSummaryPerContinent.get("Oceania").getMin()),
                  () -> assertEquals(1085755, (int) popSummaryPerContinent.get("Oceania").getAverage()),
                  () -> assertEquals(18886000, popSummaryPerContinent.get("Oceania").getMax())
        );
    }
}