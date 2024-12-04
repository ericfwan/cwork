package com.group6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * CityDAO CLASS
 * Provides methods to interact with the city data in the database.
 * Includes functions to retrieve city information based on various criteria such as name, district, continent, region, and country.
 *
 **/
public class CityDAO {

    private Connection con;             // Database connection
    private CountryService countryService;  // Service for managing country-related operations
    private Country country;              // Country object for storing country-related data

    /**
     * Constructor to initialize the CityDAO with a given database connection.
     *
     * @param con The database connection object
     **/
    public CityDAO(Connection con) {
        this.con = con; // Set the connection object for the DAO
    }

    /**
     * Fetches all cities from the database, including details of the associated country.
     *
     * @return An ArrayList of City objects representing all cities in the database.
     **/
    public ArrayList<City> getAll() {

        ArrayList<City> cities = new ArrayList<>(); // List to store cities

        try {
            // Create SQL statements for fetching city and country data
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM city"); // Execute query to fetch all cities

            // Process the result set to create city objects
            while (rs.next()) {
                City city = new City();
                city.id = rs.getInt("id");                   // Get city ID
                city.name = rs.getString("name");             // Get city name
                city.countryCode = rs.getString("countryCode"); // Get country code
                city.district = rs.getString("district");     // Get district name
                city.population = rs.getInt("population");    // Get city population

                // Fetch country details for the current city
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM country WHERE code = '" + city.countryCode + "'");
                if (rs2.next()) {
                    city.country = rs2.getString("name");      // Get country name
                    city.continent = rs2.getString("continent"); // Get continent
                    city.region = rs2.getString("region");      // Get region
                }

                // Add the city to the list if it is valid
                if (city != null) {
                    cities.add(city);
                } else {
                    throw new RuntimeException("City object is null"); // Handle unexpected null city object
                }
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            throw new RuntimeException(e);
        }

        return cities; // Return the list of cities
    }

    /**
     * Fetches a single city from the database by its name.
     *
     * @param cityName The name of the city to fetch.
     * @return A City object representing the city with the given name.
     **/
    public City getCitybyName(String cityName) {
        City city = new City(); // City object to store the fetched city data
        String query = "SELECT * FROM city WHERE name='" + cityName + "'"; // Query to fetch city by name

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // If the city is found, populate the city object
            if (rs.next()) {
                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions
            throw new RuntimeException(e);
        }

        // Return the city object if found, else throw an exception
        if (city != null) {
            return city;
        } else {
            throw new RuntimeException("City not found");
        }
    }

    /**
     * Fetches cities from the database that belong to a specified district.
     *
     * @param districtName The name of the district to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified district.
     **/
    public ArrayList<City> getCityByDistrict(String districtName) {

        ArrayList<City> cities = new ArrayList<>(); // List to store cities in the specified district
        this.country = new Country(); // Initialize the Country object
        this.countryService = new CountryService(con); // Initialize the CountryService object
        String query = " SELECT city.id, city.name, city.countryCode, city.district, city.population, " +
                "country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code"; // SQL query to join city and country data

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process the result set to filter cities by district
            while (rs.next()) {
                City city = new City();

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");

                // If the city belongs to the specified district, add it to the list
                if (city.district.equals(districtName)) {
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the query execution
            throw new RuntimeException(e);
        }

        return cities; // Return the list of cities in the specified district
    }

    /**
     * Fetches cities from the database that belong to a specified continent.
     *
     * @param continentName The name of the continent to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified continent.
     **/
    public ArrayList<City> getCityByContinent(String continentName) {

        ArrayList<City> cities = new ArrayList<>(); // List to store cities in the specified continent
        this.country = new Country(); // Initialize the Country object
        this.countryService = new CountryService(con); // Initialize the CountryService object
        String query = " SELECT city.id, city.name, city.countryCode, city.district, city.population, " +
                "country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code"; // SQL query to join city and country data

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process the result set to filter cities by continent
            while (rs.next()) {
                City city = new City();
                country = countryService.getCountry_Name(rs.getString("countryName")); // Fetch country details

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");

                // If the city belongs to the specified continent, add it to the list
                if (city.continent.equals(continentName)) {
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the query execution
            throw new RuntimeException(e);
        }

        return cities; // Return the list of cities in the specified continent
    }

    /**
     * Fetches cities from the database that belong to a specified region.
     *
     * @param regionName The name of the region to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified region.
     *
     **/
    public ArrayList<City> getCityByRegion(String regionName) {

        ArrayList<City> cities = new ArrayList<>(); // List to store cities in the specified region
        this.country = new Country(); // Initialize the Country object
        this.countryService = new CountryService(con); // Initialize the CountryService object
        String query = " SELECT city.id, city.name, city.countryCode, city.district, city.population, " +
                "country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code"; // SQL query to join city and country data

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process the result set to filter cities by region
            while (rs.next()) {
                City city = new City();
                country = countryService.getCountry_Name(rs.getString("countryName")); // Fetch country details

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");

                // If the city belongs to the specified region, add it to the list
                if (city.region.equals(regionName)) {
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the query execution
            throw new RuntimeException(e);
        }

        return cities; // Return the list of cities in the specified region
    }

    /**
     *
     * Fetches cities from the database that belong to a specified country.
     *
     * @param countryName The name of the country to filter cities by.
     * @return An ArrayList of City objects representing cities in the specified country.
     *
     **/
    public ArrayList<City> getCityByCountry(String countryName) {

        ArrayList<City> cities = new ArrayList<>(); // List to store cities in the specified country
        this.country = new Country(); // Initialize the Country object
        String query = " SELECT city.id, city.name, city.countryCode, city.district, city.population, " +
                "country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code"; // SQL query to join city and country data

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process the result set to filter cities by country
            while (rs.next()) {
                City city = new City();

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");

                // If the city belongs to the specified country, add it to the list
                if (city.country.equals(countryName)) {
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the query execution
            throw new RuntimeException(e);
        }

        return cities; // Return the list of cities in the specified country
    }
}
