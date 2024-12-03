package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

public class CountryService {

    private CountryDAO countryDAO;

    public CountryService(Connection con) {
        this.countryDAO = new CountryDAO(con);
    }

    public ArrayList<Country> getAll() {
        return countryDAO.country_getAll();
    }

    public Country getCountry_Name(String countryName) throws Exception {
        return countryDAO.getCountryByName(countryName);
    }


    public ArrayList<Country> getCountries_Continent(String continentName) throws Exception {
        return countryDAO.getCountryByContinent(continentName);
    }

    public ArrayList<Country> getCountries_Region(String regionName) throws Exception {
        return countryDAO.getCountryByRegion(regionName);
    }
}
