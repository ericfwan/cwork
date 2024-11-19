package com.napier.sem;

import java.sql.*;

public class city_Dist {
    public void run(String dist){
        try {
            // db connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");

            if (con != null) { // connection integrity check

                // Query for Countries in Antarctica
                System.out.println("Cities in " + dist + ":");
                String query = "SELECT * FROM city WHERE district = '"+dist+"' ORDER BY city.population DESC;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String name = rs.getString("Name");
                    int population = rs.getInt("Population");

                    System.out.printf("Name: %s, Population: %d\n", name, population);
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
