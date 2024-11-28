package personal.priingles;

import java.sql.Connection;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
//
//        Thread.sleep(60000);

        CountryService countryService;
        db_util db = new db_util();

        Connection con = db.getDbConnection();

        Reports report = new Reports();
//        report.allCountriesInTheWorld(con);
//        report.allCountriesInContinent(con, "Asia");
//        report.allCountriesInRegion(con, "Western Africa");
//        report.topNCountriesInWorld(con, 10);
//        report.topNCountriesInContinent(con,5,"Asia");
//        report.topNCountriesInRegion(con,5,"Western Africa");
//        report.allCitiesInWorld(con);
        System.out.println("test");



        //con.close();
             }
}
