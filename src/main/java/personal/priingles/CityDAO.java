package personal.priingles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CityDAO {

    private Connection con;


    public CityDAO (Connection con){
        this.con = con;
    }

    public ArrayList<City> getAll(){

        ArrayList<City> cities = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from city");

            while (rs.next()) {
                City city = new City();
                city.id = rs.getInt("id");
                city.name = rs.getString("name");
                city.countryCode = rs.getString("countryCode");
                city.district = rs.getString("district");
                city.population = rs.getInt("population");

//                ResultSet rs2 = stmt.executeQuery("select * from country where code = '"+city.countryCode+"'");
//                if(rs2.next()) {
//                    city.country = rs2.getString("name");
//                }
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

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from city where name='"+cityName+"'");

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
}
