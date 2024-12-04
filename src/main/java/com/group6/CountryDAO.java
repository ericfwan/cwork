package com.group6;

import java.sql.*;
import java.util.ArrayList;

/**
 * CountryDAO CLASS
 * This class handles database operations related to the 'country' table.
 * It includes methods to retrieve country data based on various criteria such as country name, continent, and region.
 */
public class CountryDAO {

    private Connection con; // Database connection
    private Country country; // Country object to hold country data

    /**
     * Constructor to initialize the CountryDAO with a database connection
     *
     * @param con The Connection object to interact with the database
     */
    public CountryDAO(Connection con) {
        this.con = con;
    }

    /**
     * Retrieves all countries from the database.
     *
     * @return An ArrayList of all countries in the database
     */
    public ArrayList<Country> country_getAll() {

        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();
            // Execute SQL query to get all countries from the 'country' table
            ResultSet rs = stmt.executeQuery("select * from country");

            // Iterate through the result set and create Country objects
            while (rs.next()) {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.surfaceArea = rs.getDouble("SurfaceArea");
                country.indepYear = rs.getInt("IndepYear");
                country.population = rs.getInt("Population");
                country.lifeExpectancy = rs.getDouble("LifeExpectancy");
                country.gnp = rs.getDouble("Gnp");
                country.gnpOld = rs.getDouble("GnpOld");
                country.localName = rs.getString("LocalName");
                country.governmentForm = rs.getString("GovernmentForm");
                country.headOfState = rs.getString("HeadOfState");
                country.capital = rs.getInt("Capital");
                country.code2 = rs.getString("Code2");

                // Add the created Country object to the list
                countries.add(country);
            }

        } catch (SQLException e) {
            // In case of an SQL error, throw a runtime exception
            throw new RuntimeException(e);
        }
        return countries; // Return the list of countries
    }

    /**
     * Retrieves a country by its name.
     *
     * @param countryName The name of the country to retrieve
     * @return A Country object containing the country's details
     * @throws Exception if the country is not found
     */
    public Country getCountryByName(String countryName) throws Exception {
        Country country = new Country();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();
            // Execute SQL query to get the country by its name
            ResultSet rs = stmt.executeQuery("select * from country where Name = '" + countryName + "'");

            // If the country is found, populate the Country object with data
            if (rs.next()) {
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.surfaceArea = rs.getDouble("SurfaceArea");
                country.indepYear = rs.getInt("IndepYear");
                country.population = rs.getInt("Population");
                country.lifeExpectancy = rs.getDouble("LifeExpectancy");
                country.gnp = rs.getDouble("Gnp");
                country.gnpOld = rs.getDouble("GnpOld");
                country.localName = rs.getString("LocalName");
                country.governmentForm = rs.getString("GovernmentForm");
                country.headOfState = rs.getString("HeadOfState");
                country.capital = rs.getInt("Capital");
                country.code2 = rs.getString("Code2");
            }
        } catch (Exception e) {
            // In case of an error, throw a runtime exception
            throw new RuntimeException(e);
        }

        // If the country object is not null, return the country
        if (country != null) {
            return country;
        } else {
            throw new Exception("Country not found");
        }
    }

    /**
     * Retrieves countries that belong to a specific continent.
     *
     * @param continentName The name of the continent to filter countries by
     * @return A list of countries in the specified continent
     * @throws Exception if no countries are found for the given continent
     */
    public ArrayList<Country> getCountryByContinent(String continentName) throws Exception {

        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();
            // Execute SQL query to get countries in the specified continent
            ResultSet rs = stmt.executeQuery("select * from country where continent = '" + continentName + "'");

            // Iterate through the result set and create Country objects
            while (rs.next()) {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.surfaceArea = rs.getDouble("SurfaceArea");
                country.indepYear = rs.getInt("IndepYear");
                country.population = rs.getInt("Population");
                country.lifeExpectancy = rs.getDouble("LifeExpectancy");
                country.gnp = rs.getDouble("Gnp");
                country.gnpOld = rs.getDouble("GnpOld");
                country.localName = rs.getString("LocalName");
                country.governmentForm = rs.getString("GovernmentForm");
                country.headOfState = rs.getString("HeadOfState");
                country.capital = rs.getInt("Capital");
                country.code2 = rs.getString("Code2");

                // Add the created Country object to the list
                countries.add(country);
            }
        } catch (Exception e) {
            // In case of an error, throw a runtime exception
            throw new RuntimeException(e);
        }

        // If countries list is not empty, return the list
        if (countries != null) {
            return countries;
        } else {
            throw new Exception("No countries found in this continent");
        }
    }

    /**
     * Retrieves countries that belong to a specific region.
     *
     * @param regionName The name of the region to filter countries by
     * @return A list of countries in the specified region
     * @throws Exception if no countries are found for the given region
     */
    public ArrayList<Country> getCountryByRegion(String regionName) throws Exception {

        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();
            // Execute SQL query to get countries in the specified region
            ResultSet rs = stmt.executeQuery("select * from country where region = '" + regionName + "'");

            // Iterate through the result set and create Country objects
            while (rs.next()) {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.surfaceArea = rs.getDouble("SurfaceArea");
                country.indepYear = rs.getInt("IndepYear");
                country.population = rs.getInt("Population");
                country.lifeExpectancy = rs.getDouble("LifeExpectancy");
                country.gnp = rs.getDouble("Gnp");
                country.gnpOld = rs.getDouble("GnpOld");
                country.localName = rs.getString("LocalName");
                country.governmentForm = rs.getString("GovernmentForm");
                country.headOfState = rs.getString("HeadOfState");
                country.capital = rs.getInt("Capital");
                country.code2 = rs.getString("Code2");

                // Add the created Country object to the list
                countries.add(country);
            }
        } catch (Exception e) {
            // In case of an error, throw a runtime exception
            throw new RuntimeException(e);
        }

        // If countries list is not empty, return the list
        if (countries != null) {
            return countries;
        } else {
            throw new Exception("No countries found in this region");
        }
    }
}
