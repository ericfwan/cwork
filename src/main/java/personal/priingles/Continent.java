package personal.priingles;

import java.sql.Connection;
import java.util.ArrayList;

public class Continent {

    private Connection con = null;

    public String name;
    public ArrayList<Country> countries;
    private db_util db = new db_util();
    private CountryService countryService;


    public Continent(String continentName) throws Exception {

        this.con = db.getDbConnection();
        countryService = new CountryService(con);
        countries = countryService.getCountries_Continent(name);
        this.name = continentName;

    }

    public String[] displayContinent(){

        int num = countries.size();
        String[] cont = {name, num + ""};
        return cont;
    }

    public void displayCountries() {

    }


    public ArrayList<Country> getCountryinCont(){
        return countries;
    }


}
