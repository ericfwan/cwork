package com.napier.sem;

import java.sql.*;

public class countryPopulationLargestToSmallest {
    public void run(){
        try {
            //db connection
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");


            if (con != null) { // connection integrity check
                String query = ("SELECT * FROM country ORDER BY population DESC");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("Results:");
                while (rs.next()) {


                    String name = rs.getString("Name");
                    int population = rs.getInt("Population");

                    System.out.printf("Name: %s, Population: %d\n" , name , population);

                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
