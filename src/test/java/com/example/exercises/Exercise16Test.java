package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise16Test {

    @Test
    void findMinMaxPopCitiesPerCountry() {
        Exercise16 exercise16 = new Exercise16();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();
        List<SummaryErRecord> ers = List.of(
                new SummaryErRecord("NZL", 3502, 3494),
                new SummaryErRecord("ARM", 128, 126),
                new SummaryErRecord("MKD", 2460, 2460),
                new SummaryErRecord("SGS", -1, -1),
                new SummaryErRecord("PRY", 2889, 2885),
                new SummaryErRecord("TKL", 3333, 3333),
                new SummaryErRecord("AGO", 60, 56),
                new SummaryErRecord("CMR", 1809, 1803),
                new SummaryErRecord("URY", 3492, 3492),
                new SummaryErRecord("GHA", 914, 910),
                new SummaryErRecord("GIN", 926, 926),
                new SummaryErRecord("CCK", 2317, 2316)
        );
        List<String> erCountries = ers.stream()
                .map(s -> s.countryCode)
                .toList();

        List<Exercise16.CountryCitySummary> result = exercise16.findMinMaxPopCitiesPerCountry(countries);

        assertNotNull(result);
        for (int i = 0; i < result.size(); i++) {
            if (i % 20 == 0)
                System.out.printf(
                        "new SummaryErRecord(\"%s\", %s, %s),%n",
                        result.get(i).country().code(),
                        result.get(i).minPopCity() != null ? result.get(i).minPopCity().id() : null,
                        result.get(i).maxPopCity() != null ? result.get(i).maxPopCity().id() : null
                );
        }
        assertNotNull(result);
        Map<String, Exercise16.CountryCitySummary> preparedResult = result.stream()
                .filter(s -> erCountries.contains(s.country().code()))
                .distinct()
                .collect(Collectors.toMap(
                        s -> s.country().code(),
                        Function.identity()
                ));

        for (SummaryErRecord er : ers) {
            Exercise16.CountryCitySummary countryCitySummary = preparedResult.get(er.countryCode());
            assertNotNull(countryCitySummary);
            if (er.minCityId() >= 0) {
                assertEquals(er.minCityId(), countryCitySummary.minPopCity().id(),
                             () -> "Min Pop City is wrong for %s country".formatted(er.countryCode()));
            }
            if (er.maxCityId() >= 0) {
                assertEquals(er.maxCityId(), countryCitySummary.maxPopCity().id(),
                             () -> "Max Pop City is wrong for %s country".formatted(er.countryCode()));
            }
        }
    }

    private record SummaryErRecord(String countryCode, int minCityId, int maxCityId) {
    }
}