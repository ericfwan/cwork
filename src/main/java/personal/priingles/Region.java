package personal.priingles;

import java.sql.Connection;
import java.util.ArrayList;

public class Region {

    private Connection con = null;

    public String regionName;
    public ArrayList<Country> countries;
    private db_util db = new db_util();
    private CountryService countryService;

    public Region(String regionName) throws Exception {

        this.con = db.getDbConnection();
        countryService = new CountryService(con);
        countries = countryService.getCountries_Continent(regionName);
        this.regionName = regionName;
    }

    public ArrayList<Country> getCountryinReg(){
        return countries;
    }

}
