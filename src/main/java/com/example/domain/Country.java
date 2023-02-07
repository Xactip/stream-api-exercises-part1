package com.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public record Country(String code, String name, String continent, int population, double surfaceArea, double gnp,
                      int capital, List<City> cities) {

    public Country {
        cities = cities != null ? cities : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", surfaceArea=" + surfaceArea +
                ", gnp=" + gnp +
                ", capital=" + capital +
                '}';
    }
}