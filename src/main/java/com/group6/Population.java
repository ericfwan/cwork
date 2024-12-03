package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

public class Population {
	long population = 0;
	Connection con;
	Country country;
	City city;
	CountryService countryService;
	CityService cityService;
	ArrayList<Country> countries;
	ArrayList<City> cities;


	public void world(Connection con) {

		this.population = 0;
		countryService = new CountryService(con);
		countries = countryService.getAll();

		for(Country country: countries) {
			this.population += country.getPopulation();
		}

		System.out.println(population);

	}

	public void continent(Connection con, String continentName) throws Exception {

		this.population = 0;
		countryService = new CountryService(con);
		countries = countryService.getCountries_Continent(continentName);

		for(Country country: countries) {
			this.population += country.getPopulation();
		}

		System.out.println(population);
	}

	public void region(Connection con, String regionName) throws Exception {

		this.population = 0;
		countryService = new CountryService(con);
		countries = countryService.getCountries_Region(regionName);

		for(Country country: countries) {
			this.population += country.getPopulation();
		}

		System.out.println(population);
	}

	public void country(Connection con, String countryName) throws Exception {

		this.population = 0;
		this.country = countryService.getCountry_Name(countryName);
		this.population = country.getPopulation();
		System.out.println(population);
	}

	public void district(Connection con, String districtName) throws Exception {
		this.population = 0;
		this.cityService = new CityService(con);
		cities = cityService.getByDistrict(districtName);

		for(City city: cities) {
			this.population += city.getPopulation();
		}

		System.out.println(population);
	}

	public void city(Connection con, String cityName) throws Exception {
		this.population = 0;
		this.cityService = new CityService(con);
		this.city = cityService.getCity(cityName);
		this.population = city.getPopulation();
		System.out.println(population);
	}

}
