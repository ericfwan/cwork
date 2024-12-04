package com.group6;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * REPORTS CLASS
 * contains all company requested reports
 *
 * **/

public class Reports{

    CountryService countryService;
    CityService cityService;
    long nPopulation = 0;
    long cityPopulation = 0;

    /** REPORT_1: All COUNTRIES in the WORLD from largest to smallest
    **/
    public void allCountriesInWorld(Connection con){

        countryService = new CountryService(con);

        ArrayList<Country> countries;
        countries = countryService.getAll();

        //sorts list in reverse order of population
        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );
        System.out.println("___________________________________________________________________________________________________________________________________________");
        for (Country country : countries) {
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println("___________________________________________________________________________________________________________________________________________");
        }
    }

    /** REPORT_2:  All COUNTRIES in a CONTINENT from largest to smallest
    **/
    public void allCountriesInContinent(Connection con, String continentName) throws Exception {

        countryService = new CountryService(con);

        ArrayList<Country> countries;
        countries = countryService.getCountries_Continent(continentName);

        //sorts list in reverse order of population
        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (Country country : countries) {
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }




    }

    /// REPORT_3: All COUNTRIES in a REGION from largest to smallest
    ///
    public void allCountriesInRegion(Connection con, String regionName) throws Exception {

        countryService = new CountryService(con);

        ArrayList<Country> countries;
        countries = countryService.getCountries_Region(regionName);

        //sorts list in reverse order of population
        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (Country country : countries) {
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }
    }

    /// REPORT_4: Top -user-provided_N- COUNTRIES in the WORLD
    ///
    public void topNCountriesInWorld(Connection con, int top){

        countryService = new CountryService(con);
        ArrayList<Country> countries;
        countries = countryService.getAll();

        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (int start = 0; start < top; start++) {

            Country country = countries.get(start);
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }

    }

    /// REPORT_5: Top -user-provided_N- COUNTRIES in a CONTINENT
    ///
    public void topNCountriesInContinent(Connection con, int top, String continentName) throws Exception {

        countryService = new CountryService(con);
        ArrayList<Country> countries;
        countries = countryService.getCountries_Continent(continentName);

        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (int start = 0; start < top; start++) {

            Country country = countries.get(start);
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }

    }

    /// REPORT_6: Top -user-provided_N- COUNTRIES in a REGION
    ///
    public void topNCountriesInRegion(Connection con, int top, String regionName) throws Exception {

        countryService = new CountryService(con);
        ArrayList<Country> countries;
        countries = countryService.getCountries_Region(regionName);

        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (int start = 0; start < top; start++) {

            Country country = countries.get(start);
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }

    }

    /// REPORT_7: All CITIES in the WORLD
    ///
    public void allCitiesInWorld(Connection con) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-17s\n", "Name", "Country", "District", "Population");

        for (City city : cities) {
            System.out.printf("%-35s %-35s %-30s %-17d\n", city.name, city.country,city.district, city.population);
        }

        System.out.println(cities.size());
    }

    /// REPORT_8: All CITIES in a CONTINENT
    ///
    public void allCitiesInContinent(Connection con, String continentName) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-17s\n", "Name", "Country", "Continent", "District", "Population");

        for (City city : cities) {
            if (city.continent.equals(continentName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);

            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_9: All CITIES in a REGION
    ///
    public void allCitiesInRegion(Connection con, String regionName) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (City city : cities) {
            if (city.region.equals(regionName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);

            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_10: All CITIES in a COUNTRY
    ///
    public void allCitiesInCountry(Connection con, String countryName) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (City city : cities) {
            if (city.country.equals(countryName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);

            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_11: All CITIES in a DISTRICT
    ///
    public void allCitiesInDistrict(Connection con, String districtName) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (City city : cities) {
            if (city.district.equals(districtName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);

            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_12: Top -user-provided_N- CITIES in the WORLD
    ///
    public void topNCitiesInWorld(Connection con, int top) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (int start = 0; start < top; start++) {
            City city = cities.get(start);
            System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);
        }
        System.out.println(cities.size());
    }

    /// REPORT_13: Top -user-provided_N- CITIES in a CONTINENT
    ///
    public void topNCitiesInContinent(Connection con, int top, String continentName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (int start = 0; start < top; start++) {
            City city = cities.get(start);
            if (city.continent.equals(continentName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);
            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_!4: Top -user-provided_N- CITIES in a REGION
    ///
    public void topNCitiesInRegion(Connection con, int top, String regionName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (int start = 0; start < top; start++) {
            City city = cities.get(start);
            if (city.region.equals(regionName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);
            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_15: Top -user-provided_N- CITIES in a COUNTRY
    ///
    public void topNCitiesInCountry(Connection con, int top, String countryName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (int start = 0; start < top; start++) {
            City city = cities.get(start);
            if (city.country.equals(countryName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);
            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_16: Top -user-provided_N- CITIES in a DISTRICT
    ///
    public void topNCitiesInDistrict(Connection con, int top, String districtName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17s\n", "Name", "Country", "Region", "Continent", "District", "Population");

        for (int start = 0; start < top; start++) {
            City city = cities.get(start);
            if (city.district.equals(districtName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-30s %-17d\n", city.name, city.country, city.region, city.continent, city.district, city.population);
            }
        }
        System.out.println(cities.size());
    }

    /// REPORT_17: All CAPITAL CITIES in the WORLD
    ///
    public void allCapitalCitiesInWorld(Connection con) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-17s\n", "Name", "Country", "District", "Population");

        for (City city : cities) {
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_18: All CAPITAL_CITIES in a CONTINENT
    ///
    public void allCapitalCitiesInContinent(Connection con, String continentName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30S %-17s\n", "Name", "Country", "Continent", "District", "Population");

        for (City city : cities) {
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id && city.continent.equals(continentName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_19: All CAPITAL_CITIES in a REGION
    ///
    public void allCapitalCitiesInRegion(Connection con, String regionName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30S %-17s\n", "Name", "Country", "Continent", "District", "Population");

        for (City city : cities) {
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id && city.region.equals(regionName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_20: Top -user-provided_N- CAPITAL_CITIES in WORLD
    ///
    public void topNCapitalCitiesInWorld(Connection con, int top) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-17s\n", "Name", "Country", "District", "Population");

        int count = 0;

        for (City city : cities) {
            if(count == top){
                break;
            }
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
                count++;
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_21: Top -user-provided_N- CAPITAL_CITIES in a CONTINENT
    ///
    public void topNCapitalCitiesInContinent(Connection con, int top, String continentName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-17s\n", "Name", "Country", "Continent", "District", "Population");

        int count = 0;

        for (City city : cities) {
            if(count == top){
                break;
            }
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id && country.continent.equals(continentName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
                count++;
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_22: Top -user-provided_N- CAPITAL_CITIES in a REGION
    ///
    public void topNCapitalCitiesInRegion(Connection con, int top, String regionName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-35s %-35s %-30s %-30s %-17s\n", "Name", "Country", "Continent", "District", "Population");

        int count = 0;

        for (City city : cities) {
            if(count == top){
                break;
            }
            Country country = countryService.getCountry_Name(city.country);
            if(country.capital == city.id && country.region.equals(regionName)) {
                System.out.printf("%-35s %-35s %-30s %-30s %-17d\n", city.name, city.country, city.continent, city.district, city.population);
                count++;
            }
        }

        System.out.println(cities.size());
    }

    /// REPORT_23: The population people living in cities and people not in each CONTINENT
    ///
    public void in_OutCityPopulationByContinent(Connection con, String continentName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<Country> countries = countryService.getCountries_Continent(continentName);
        ArrayList<City> cities = cityService.getByContinent(continentName);


        for (Country country : countries) {
            nPopulation += country.population;
        }

        for (City city : cities) {
            cityPopulation += city.population;
        }

        System.out.println("In the continent of "+continentName+", "+cityPopulation+" people live in cities, while "+(nPopulation-cityPopulation)+" people don't.");
    }

    /// REPORT_24: The population people living in cities and people not in each REGION
    ///
    public void inOutCityPopulationByRegion(Connection con, String regionName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<Country> countries = countryService.getCountries_Region(regionName);
        ArrayList<City> cities = cityService.getByRegion(regionName);

        nPopulation = 0;

        for (Country country : countries) {
            nPopulation += country.population;
        }

        for (City city : cities) {
            cityPopulation += city.population;
        }

        System.out.println("In the region of "+regionName+", "+cityPopulation+" people live in cities, while "+(nPopulation -cityPopulation)+" people don't.");
    }

    /// REPORT_25: The population people living in cities and people not in each COUNTRY
    ///
    public void inOutCityPopulationByCountry(Connection con, String countryName) throws Exception {
        countryService = new CountryService(con);
        cityService = new CityService(con);

        Country country = countryService.getCountry_Name(countryName);
        ArrayList<City> cities = cityService.getByCountry(countryName);

        nPopulation = country.population;

        for (City city : cities) {
            cityPopulation += city.population;
        }

        System.out.println("In "+countryName+", "+cityPopulation+" people live in cities, while "+(nPopulation -cityPopulation)+" people don't.");
    }


}