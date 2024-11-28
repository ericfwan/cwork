package personal.priingles;

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

    /// REPORT_1: All countries in the world from largest to smallest
    ///
    public void allCountriesInWorld(Connection con){

        countryService = new CountryService(con);

        ArrayList<Country> countries;
        countries = countryService.getAll();

        //sorts list in reverse order of population
        countries.sort(Comparator.comparingInt(Country::getPopulation).reversed());

        System.out.printf("%-7s %-45s %-20s %-30s %-17s %-10s\n", "Code", "Name","Continent", "Region", "Population", "Capital" );

        for (Country country : countries) {
            System.out.printf("%-7s %-45s %-20s %-30s %-17d %-10s\n", country.code, country.name, country.continent, country.region, country.population, country.capital);
        }
    }

    /// REPORT_2:  All countries in a continent from largest to smallest
    ///
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

    /// REPORT_3: All countries in a region from largest to smallest
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

    public void allCitiesInWorld(Connection con) throws Exception {

        countryService = new CountryService(con);
        cityService = new CityService(con);

        ArrayList<City> cities;
        cities = cityService.getAll();

        //sorts list in reverse order of population
        cities.sort(Comparator.comparingInt(City::getPopulation).reversed());

        System.out.printf("%-45s %-20s %-30s %-17s\n", "Name", "Country", "District", "Population");

        for (City city : cities) {
            System.out.printf("%-45s %-20s %-30s %-17d\n", city.name, city.country,city.district, city.population);
        }

        System.out.println(cities.size());
    }
}