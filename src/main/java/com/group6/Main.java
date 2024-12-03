package com.group6;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws Exception {


        CountryService countryService;
        db_util db = new db_util();
        Connection con = db.getDbConnection();
        Reports report = new Reports();
        Population population = new Population();
//        report.in_OutCityPopulationByContinent(con, "Africa");
//        report.inOutCityPopulationByRegion(con, "Western Africa");
//        report.inOutCityPopulationByCountry(con, "Nigeria");
        population.world(con);
        population.continent(con, "Asia");
        population.country(con, "Nigeria");
        population.region(con, "Western Africa");
        population.district(con, "Gelderland");
        population.city(con, "San Diego");


        System.out.println("test");



        //con.close();
             }
}
