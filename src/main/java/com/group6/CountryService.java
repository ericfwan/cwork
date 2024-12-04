package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * CountryService CLASS
 * This class acts as a service layer for interacting with the data access object (DAO) layer.
 * It provides methods to retrieve country information through the CountryDAO class.
 */
public class CountryService {

    private CountryDAO countryDAO; // Instance of the CountryDAO to interact with the database

    /**
     * Constructor to initialize the CountryService with a database connection.
     * This constructor creates an instance of CountryDAO.
     *
     * @param con The Connection object used to interact with the database.
     */
    public CountryService(Connection con) {
        this.countryDAO = new CountryDAO(con);
    }

    /**
     * Retrieves all countries from the database.
     *
     * @return An ArrayList of all countries in the database.
     */
    public ArrayList<Country> getAll() {
        // Delegate the responsibility to CountryDAO to get all countries
        return countryDAO.country_getAll();
    }

    /**
     * Retrieves a country by its name.
     *
     * @param countryName The name of the country to retrieve.
     * @return A Country object containing the country's details.
     * @throws Exception if the country with the given name is not found.
     */
    public Country getCountry_Name(String countryName) throws Exception {
        // Delegate the responsibility to CountryDAO to get the country by its name
        return countryDAO.getCountryByName(countryName);
    }

    /**
     * Retrieves all countries that belong to a specific continent.
     *
     * @param continentName The name of the continent to filter countries by.
     * @return An ArrayList of countries in the specified continent.
     * @throws Exception if no countries are found for the given continent.
     */
    public ArrayList<Country> getCountries_Continent(String continentName) throws Exception {
        // Delegate the responsibility to CountryDAO to get countries by continent
        return countryDAO.getCountryByContinent(continentName);
    }

    /**
     * Retrieves all countries that belong to a specific region.
     *
     * @param regionName The name of the region to filter countries by.
     * @return An ArrayList of countries in the specified region.
     * @throws Exception if no countries are found for the given region.
     */
    public ArrayList<Country> getCountries_Region(String regionName) throws Exception {
        // Delegate the responsibility to CountryDAO to get countries by region
        return countryDAO.getCountryByRegion(regionName);
    }
}
