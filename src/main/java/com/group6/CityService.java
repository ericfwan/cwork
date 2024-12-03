package com.group6;

import java.sql.Connection;
import java.util.ArrayList;

public class CityService {

    private CityDAO cityDAO;

    public CityService(Connection con) {
        this.cityDAO = new CityDAO(con);
    }

    public City getCity(String countryName) throws Exception {
        return cityDAO.getCitybyName(countryName);
    }

    public ArrayList<City> getAll() throws Exception {
        return cityDAO.getAll();
    }

    public ArrayList<City> getByContinent(String continentName) throws Exception {
        return cityDAO.getCityByContinent(continentName);
    }

    public ArrayList<City> getByRegion(String regionName) throws Exception {
        return cityDAO.getCityByRegion(regionName);
    }

    public ArrayList<City> getByCountry(String countryName) throws Exception {
        return cityDAO.getCityByCountry(countryName);
    }

    public ArrayList<City> getByDistrict(String districtName) throws Exception {
        return cityDAO.getCityByDistrict(districtName);
    }




}
