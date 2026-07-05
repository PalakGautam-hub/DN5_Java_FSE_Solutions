package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private final ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    public Country getIndia() {
        return context.getBean("countryIN", Country.class);
    }

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(context.getBean("countryUS", Country.class));
        countries.add(context.getBean("countryDE", Country.class));
        countries.add(context.getBean("countryIN", Country.class));
        countries.add(context.getBean("countryJP", Country.class));
        return countries;
    }

    public Country getCountryByCode(String code) {
        return getAllCountries()
                .stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}
