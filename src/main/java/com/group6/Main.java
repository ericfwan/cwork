package com.group6;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws Exception {
//
//        Thread.sleep(60000);

        CountryService countryService;
        db_util db = new db_util();
        Connection con = db.getDbConnection();
        Reports report = new Reports();
        report.inOutCityPopulationByContinent(con, "Asia");
        report.inOutCityPopulationByRegion(con, "Western Africa");
        report.inOutCityPopulationByCountry(con, "Nigeria");


        System.out.println("test");



        //con.close();
             }
}
