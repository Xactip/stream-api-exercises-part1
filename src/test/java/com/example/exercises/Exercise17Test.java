package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import com.example.util.DoubleSummaryGaussianStatistics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise17Test {

    @Test
    void calcMinMaxAvgStDevOfGnp() {
        Exercise17 exercise17 = new Exercise17();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        DoubleSummaryGaussianStatistics summary = exercise17.calcMinMaxAvgStDevOfGnp(countries);

        assertNotNull(summary);
        assertAll(() -> assertEquals(407040910538L, (long) (summary.getVariance())),
                  () -> assertEquals(636661, (int) summary.getStdVariance()),
                  () -> assertEquals(0, (int) summary.getMin()),
                  () -> assertEquals(122823, (int) summary.getAverage()),
                  () -> assertEquals(8510700, (int) summary.getMax())
        );
    }
}