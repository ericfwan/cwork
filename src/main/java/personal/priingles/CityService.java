package personal.priingles;

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


}
