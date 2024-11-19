package com.napier.sem;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class countPopLtoS {
    public void run(){
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");


            if (con != null) {
                String query = ("SELECT * FROM city");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("City Content:");
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String countryCode = rs.getString("CountryCode");
                    String district = rs.getString("district");
                    int population = rs.getInt("population");

                    System.out.printf("ID: %d, Name: %s, Country: %s, District: %s, Population: %d\n", id, name, countryCode, district, population);

                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
