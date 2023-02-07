package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.LongSummaryStatistics;

import static org.junit.jupiter.api.Assertions.*;

class Exercise11Test {

    @Test
    void calcPopStatisticSummary() {
        Exercise11 exercise11 = new Exercise11();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        LongSummaryStatistics popStatisticSummary = exercise11.calcPopStatisticSummary(countries);

        assertNotNull(popStatisticSummary);
        assertAll(() -> assertEquals(0, popStatisticSummary.getMin()),
                  () -> assertEquals(25434098, (int) popStatisticSummary.getAverage()),
                  () -> assertEquals(1277558000, popStatisticSummary.getMax())
        );
    }
}