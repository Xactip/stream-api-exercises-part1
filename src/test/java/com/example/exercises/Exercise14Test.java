package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise14Test {

    @Test
    void findMinMaxPopCountriesPerContinent() {
        Exercise14 exercise14 = new Exercise14();
        List<Country> countries = InMemoryWorldDao.getInstance().findAllCountries();

        Map<String, Exercise14.MinMaxPopCountries> minMaxPopCountriesPerContinent =
                exercise14.findMinMaxPopCountriesPerContinent(countries);

        assertNotNull(minMaxPopCountriesPerContinent);
        assertAll(() -> assertEquals(List.of("FLK"), minMaxPopCountriesPerContinent.get("South America").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("BRA"), minMaxPopCountriesPerContinent.get("South America").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("MDV"), minMaxPopCountriesPerContinent.get("Asia").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("CHN"), minMaxPopCountriesPerContinent.get("Asia").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("VAT"), minMaxPopCountriesPerContinent.get("Europe").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("RUS"), minMaxPopCountriesPerContinent.get("Europe").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("IOT"), minMaxPopCountriesPerContinent.get("Africa").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("NGA"), minMaxPopCountriesPerContinent.get("Africa").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("ATA", "ATF", "SGS", "BVT", "HMD"), minMaxPopCountriesPerContinent.get("Antarctica").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("ATA", "ATF", "SGS", "BVT", "HMD"), minMaxPopCountriesPerContinent.get("Antarctica").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("SPM"), minMaxPopCountriesPerContinent.get("North America").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("USA"), minMaxPopCountriesPerContinent.get("North America").max().stream().map(Country::code).toList()),

                  () -> assertEquals(List.of("UMI"), minMaxPopCountriesPerContinent.get("Oceania").min().stream().map(Country::code).toList()),
                  () -> assertEquals(List.of("AUS"), minMaxPopCountriesPerContinent.get("Oceania").max().stream().map(Country::code).toList())
        );
    }
}