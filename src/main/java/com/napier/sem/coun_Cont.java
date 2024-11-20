package com.napier.sem;

import java.sql.*;

public class coun_Cont {
    public void run(App app, String cont){
        try {
            // db connection
            Connection con = app.connectToDatabase();
            if (con != null) { // connection integrity check

                // Query for Countries in Antarctica
                System.out.println("Countries in " + cont + ":");
                String queryContinent = "SELECT * FROM country WHERE continent = '"+cont+"' ORDER BY population DESC;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryContinent);

                while (rs.next()) {
                    String name = rs.getString("Name");
                    String continent = rs.getString("Continent");
                    int population = rs.getInt("Population");

                    System.out.printf("Continent: %s, Name: %s, Population: %d\n", continent, name, population);
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
