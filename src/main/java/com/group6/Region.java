package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * The Region class represents a geographical region that contains a list of countries.
 * It fetches the list of countries in a given region from the database using the CountryService.
 */
public class Region {

    private Connection con = null;  // Database connection

    public String regionName;  // Name of the region
    public ArrayList<Country> countries;  // List of countries in the region
    private db_util db = new db_util();  // Database utility class for establishing connections
    private CountryService countryService;  // Service to fetch country data

    /**
     * Constructor to initialize a Region object with a given region name.
     * This constructor fetches the list of countries belonging to that region
     * from the database using the CountryService.
     *
     * @param regionName The name of the region.
     * @throws Exception If there's an issue fetching country data from the database.
     */
    public Region(String regionName) throws Exception {
        // Get the database connection
        this.con = db.getDbConnection();

        // Initialize CountryService to fetch country data
        countryService = new CountryService(con);

        // Fetch the countries in the given region
        countries = countryService.getCountries_Continent(regionName);

        // Set the region name
        this.regionName = regionName;
    }

    /**
     * Retrieves the list of countries in the region.
     *
     * @return An ArrayList containing the countries in the region.
     */
    public ArrayList<Country> getCountryinReg() {
        return countries;
    }
}
