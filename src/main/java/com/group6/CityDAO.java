package com.group6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CityDAO {

    private Connection con;
    private CountryService countryService;
    private Country country;


    public CityDAO (Connection con){
        this.con = con;
    }

    public ArrayList<City> getAll(){

        ArrayList<City> cities = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from city");

            while (rs.next()) {
                City city = new City();
                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");

                ResultSet rs2 = stmt2.executeQuery("select * from country where code = '"+city.countryCode+"'");
                if(rs2.next()) {
                    city.country = rs2.getString("name");
                    city.continent = rs2.getString("continent");
                    city.region = rs2.getString("region");

                }


                if (city != null) {
                    cities.add(city);
                } else {
                    throw new RuntimeException();
                }
            }


        } catch(SQLException e){
                throw new RuntimeException(e);
            }

        return cities;

    }

    public City  getCitybyName(String cityName){
        City city = new City();
        String query = "select * from city where name='"+cityName+"'";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){


            if(rs.next()) {
                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(city != null) {
            return city;
        }else{
            throw new RuntimeException();
        }

    }

    public ArrayList<City> getCityByDistrict(String districtName){

        ArrayList<City> cities = new ArrayList<>();
        this.country = new Country();
        this.countryService = new CountryService(con);
        String query = (" SELECT city.id, city.name, city.countryCode, city.district, city.population, country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code");

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){


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


                if (city.district.equals(districtName)){
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cities;
    }

    public ArrayList<City> getCityByContinent(String continentName){

        ArrayList<City> cities = new ArrayList<>();
        this.country = new Country();
        this.countryService = new CountryService(con);
        String query = (" SELECT city.id, city.name, city.countryCode, city.district, city.population, country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code");

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){


            while (rs.next()) {
                City city = new City();
                country = countryService.getCountry_Name(rs.getString("countryName"));

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");


                if (city.continent.equals(continentName)){
                    cities.add(city);
                }
            }
        } catch (Exception e) {
			throw new RuntimeException(e);
		}

		return cities;
    }

    public ArrayList<City> getCityByRegion(String regionName){

        ArrayList<City> cities = new ArrayList<>();
        this.country = new Country();
        this.countryService = new CountryService(con);
        String query = (" SELECT city.id, city.name, city.countryCode, city.district, city.population, country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code");

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){


            while (rs.next()) {
                City city = new City();
                country = countryService.getCountry_Name(rs.getString("countryName"));

                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");
                city.country = rs.getString("countryName");
                city.continent = rs.getString("continent");
                city.region = rs.getString("region");


                if (city.region.equals(regionName)){
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cities;
    }

    public ArrayList<City> getCityByCountry(String countryName){

        ArrayList<City> cities = new ArrayList<>();
        this.country = new Country();
        String query = (" SELECT city.id, city.name, city.countryCode, city.district, city.population, country.name AS countryName, country.continent, country.region " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code");

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){


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


                if (city.country.equals(countryName)){
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cities;
    }
}

