package com.napier.sem;

import java.sql.*;

public class coun_Reg {
    public void run(String reg){
        try {
            // db connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");

            if (con != null) { // connection integrity check

                // Query for Countries in Antarctica
                System.out.println("Countries in " + reg + ":");
                String queryRegion = "SELECT * FROM country WHERE region = '"+reg+"' ORDER BY population DESC;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryRegion);

                while (rs.next()) {
                    String name = rs.getString("Name");
                    String region = rs.getString("Region");
                    int population = rs.getInt("Population");

                    System.out.printf("Region: %s, Name: %s, Population: %d\n", region, name, population);
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

