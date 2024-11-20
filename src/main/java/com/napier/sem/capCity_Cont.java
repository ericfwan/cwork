package com.napier.sem;

import java.sql.*;

public class capCity_Cont {
    public void run(String cont){
        try {
            //db connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");


            if (con != null) { // connection integrity check
                String query = ("SELECT * FROM city JOIN country ON city.countrycode = country.code WHERE city.id = country.capital and country.continent = '"+cont+"' ORDER BY city.population DESC;");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("Capital Cities in " +cont+ ":");
                while (rs.next()) {


                    String name = rs.getString("Name");
                    String country = rs.getString("country.name");
                    int population = rs.getInt("Population");

                    System.out.printf("Country: %s, Name: %s, Population: %d\n", country, name , population);

                }
                System.out.println("\n\n\n\n");
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
