package com.napier.sem;

import java.sql.*;

public class topNCapCity_Cont {
    public void run(App app, int top, String cont){
        try {
            // db connection
            Connection con = app.connectToDatabase();
            if (con != null) { // connection integrity check

                // Query for Countries in Antarctica
                System.out.println("Top " +top+ " Cities " +cont+ ":");
                String queryCity = "SELECT * FROM city JOIN country ON city.id = country.capital and country.continent = '"+cont+"' ORDER BY city.population DESC LIMIT " +top+ ";";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryCity);

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
