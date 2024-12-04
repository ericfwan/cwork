package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * CityService CLASS
 * Provides higher-level service methods that interact with the CityDAO to retrieve city data.
 * This class serves as a bridge between the application and the DAO layer, allowing other parts of the application
 * to fetch city data based on different filters such as country, continent, region, and district.
 */
public class CityService {

    private CityDAO cityDAO; // Instance of CityDAO to interact with the database

    /**
     * Constructor to initialize the CityService with a database connection.
     * This will also initialize the CityDAO to perform database operations.
     *
     * @param con The database connection object
     */
    public CityService(Connection con) {
        this.cityDAO = new CityDAO(con); // Initialize CityDAO with the provided connection
    }

    /**
     * Fetches a single city based on the specified country name.
     *
     * @param countryName The name of the country to filter cities by.
     * @return A City object representing the city with the given country name.
     * @throws Exception If the city could not be fetched or there is a database issue.
     */
    public City getCity(String countryName) throws Exception {
        return cityDAO.getCitybyName(countryName); // Delegate the fetching to CityDAO
    }

    /**
     * Fetches all cities from the database.
     *
     * @return An ArrayList of City objects representing all cities in the database.
     * @throws Exception If cities could not be fetched or there is a database issue.
     */
    public ArrayList<City> getAll() throws Exception {
        return cityDAO.getAll(); // Delegate the fetching to CityDAO
    }

    /**
     * Fetches cities that belong to the specified continent.
     *
     * @param continentName The name of the continent to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified continent.
     * @throws Exception If cities could not be fetched or there is a database issue.
     */
    public ArrayList<City> getByContinent(String continentName) throws Exception {
        return cityDAO.getCityByContinent(continentName); // Delegate the fetching to CityDAO
    }

    /**
     * Fetches cities that belong to the specified region.
     *
     * @param regionName The name of the region to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified region.
     * @throws Exception If cities could not be fetched or there is a database issue.
     */
    public ArrayList<City> getByRegion(String regionName) throws Exception {
        return cityDAO.getCityByRegion(regionName); // Delegate the fetching to CityDAO
    }

    /**
     * Fetches cities that belong to the specified country.
     *
     * @param countryName The name of the country to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified country.
     * @throws Exception If cities could not be fetched or there is a database issue.
     */
    public ArrayList<City> getByCountry(String countryName) throws Exception {
        return cityDAO.getCityByCountry(countryName); // Delegate the fetching to CityDAO
    }

    /**
     * Fetches cities that belong to the specified district.
     *
     * @param districtName The name of the district to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified district.
     * @throws Exception If cities could not be fetched or there is a database issue.
     */
    public ArrayList<City> getByDistrict(String districtName) throws Exception {
        return cityDAO.getCityByDistrict(districtName); // Delegate the fetching to CityDAO
    }
}
