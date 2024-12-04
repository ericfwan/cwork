package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Continent CLASS
 * Represents a continent and its associated countries.
 * Provides methods to retrieve country data and display continent information.
 */
public class Continent {

    private Connection con = null; // Database connection object to interact with the database
    public String name; // Name of the continent
    public ArrayList<Country> countries; // List of countries in this continent
    private db_util db = new db_util(); // Utility class for managing database connections
    private CountryService countryService; // Service class to fetch country data

    /**
     * Constructor for the Continent class.
     * Initializes the database connection, retrieves countries belonging to the specified continent,
     * and sets the continent's name.
     *
     * @param continentName The name of the continent (e.g., "Asia", "Europe").
     * @throws Exception If there is an error with the database connection or retrieving the country data.
     */
    public Continent(String continentName) throws Exception {
        this.con = db.getDbConnection(); // Establish a connection to the database
        countryService = new CountryService(con); // Initialize the CountryService to fetch country data
        countries = countryService.getCountries_Continent(continentName); // Fetch countries belonging to the specified continent
        this.name = continentName; // Set the continent name
    }

    /**
     * Returns basic information about the continent, including its name and the number of countries in it.
     *
     * @return A string array where the first element is the continent's name and the second is the number of countries.
     */
    public String[] displayContinent() {
        int num = countries.size(); // Get the number of countries in the continent
        String[] cont = {name, num + ""}; // Return an array with the continent's name and the number of countries as strings
        return cont;
    }

    /**
     * Displays the countries in the continent.
     * This method is currently empty and can be extended to display the country names, either in a GUI or on the console.
     */
    public void displayCountries() {
        // This method could be implemented to print or list the names of countries in the continent
    }

    /**
     * Returns the list of countries in the continent.
     *
     * @return An ArrayList of Country objects representing the countries within the continent.
     */
    public ArrayList<Country> getCountryinCont() {
        return countries;
    }
}
