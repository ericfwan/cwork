package com.group6;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws Exception {


        CountryService countryService;
        db_util db = new db_util();
        Connection con = db.getDbConnection();
        Reports report = new Reports();
        Population population = new Population();

        report.allCountriesInWorld(con);
        report.allCountriesInContinent(con, "Asia");


    }
}
