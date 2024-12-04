package com.group6;

/**
 * Country CLASS
 * Represents a country with various attributes such as name, code, continent, population, and more.
 * Includes getter and setter methods for each attribute and methods for displaying country data.
 */
public class Country {

    // Attributes of the country
    public String code; // Country code (e.g., "USA", "IND")
    public String name; // Name of the country (e.g., "United States", "India")
    public String continent; // Continent the country is located in (e.g., "North America", "Asia")
    public String region; // The region the country belongs to (e.g., "Western Europe", "Southeast Asia")
    public double surfaceArea; // The surface area of the country in square kilometers
    public int indepYear; // Year of independence of the country
    public int population; // The population of the country
    public double lifeExpectancy; // Life expectancy in the country
    public double gnp; // Gross National Product (GNP) of the country
    public double gnpOld; // Old Gross National Product (GNP) of the country (historical value)
    public String localName; // Local name of the country in its native language
    public String governmentForm; // Type of government (e.g., "Republic", "Monarchy")
    public String headOfState; // Name of the head of state (e.g., "President", "King")
    public int capital; // Capital city code (from the city database)
    public String code2; // Short code for the country (e.g., "US", "IN")

    // Array to hold country display information
    String[] coun;

    /**
     * Getter for country code
     *
     * @return The country code (e.g., "USA")
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for country code
     *
     * @param code The country code (e.g., "USA")
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for country name
     *
     * @return The name of the country (e.g., "United States")
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for country name
     *
     * @param name The name of the country (e.g., "United States")
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for continent name
     *
     * @return The continent the country belongs to (e.g., "North America")
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Setter for continent name
     *
     * @param continent The continent the country belongs to (e.g., "North America")
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Getter for region name
     *
     * @return The region the country is located in (e.g., "Western Europe")
     */
    public String getRegion() {
        return region;
    }

    /**
     * Setter for region name
     *
     * @param region The region the country is located in (e.g., "Western Europe")
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Getter for surface area
     *
     * @return The surface area of the country in square kilometers
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Setter for surface area
     *
     * @param surfaceArea The surface area of the country in square kilometers
     */
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Getter for the year of independence
     *
     * @return The year the country gained independence
     */
    public int getIndepYear() {
        return indepYear;
    }

    /**
     * Setter for year of independence
     *
     * @param indepYear The year the country gained independence
     */
    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    /**
     * Getter for population
     *
     * @return The population of the country
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Setter for population
     *
     * @param population The population of the country
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Getter for life expectancy
     *
     * @return The life expectancy in the country
     */
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Setter for life expectancy
     *
     * @param lifeExpectancy The life expectancy in the country
     */
    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Getter for GNP (Gross National Product)
     *
     * @return The GNP of the country
     */
    public double getGnp() {
        return gnp;
    }

    /**
     * Setter for GNP (Gross National Product)
     *
     * @param gnp The GNP of the country
     */
    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    /**
     * Getter for old GNP (historical value)
     *
     * @return The old GNP value
     */
    public double getGnpOld() {
        return gnpOld;
    }

    /**
     * Setter for old GNP (historical value)
     *
     * @param gnpOld The old GNP value
     */
    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    /**
     * Getter for local name of the country
     *
     * @return The local name of the country in its native language
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Setter for local name of the country
     *
     * @param localName The local name of the country in its native language
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * Getter for the form of government
     *
     * @return The form of government in the country (e.g., "Republic", "Monarchy")
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Setter for the form of government
     *
     * @param governmentForm The form of government in the country (e.g., "Republic", "Monarchy")
     */
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    /**
     * Getter for the head of state
     *
     * @return The name of the head of state (e.g., "President", "King")
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Setter for the head of state
     *
     * @param headOfState The name of the head of state (e.g., "President", "King")
     */
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    /**
     * Getter for capital city code
     *
     * @return The capital city code (e.g., 1 for Washington D.C., 2 for New Delhi)
     */
    public int getCapital() {
        return capital;
    }

    /**
     * Setter for capital city code
     *
     * @param capital The capital city code (e.g., 1 for Washington D.C., 2 for New Delhi)
     */
    public void setCapital(int capital) {
        this.capital = capital;
    }

    /**
     * Getter for the short country code (e.g., "US" for United States)
     *
     * @return The short country code (e.g., "US")
     */
    public String getCode2() {
        return code2;
    }

    /**
     * Setter for the short country code (e.g., "US" for United States)
     *
     * @param code2 The short country code (e.g., "US")
     */
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    /**
     * Displays basic information about the country such as its code, name, continent, and population.
     *
     * @return A string array containing the country code, name, continent, and population as strings.
     */
    public String[] displayCountry() {
        if (name != null) {
            String Population = Integer.toString(population); // Convert population to string
            String[] coun = {code, name, continent, Population}; // Store country details in an array
            this.coun = coun; // Set the class-level coun variable
        } else {
            System.out.println("Country is null");
        }

        return coun; // Return the country details array
    }
}
