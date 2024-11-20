package com.napier.sem;

import java.sql.*;

public class city_World {
    public void run(App app){
        try {
            //db connection
            Connection con = app.connectToDatabase();

            if (con != null) { // connection integrity check
                String query = ("SELECT * FROM city ORDER BY population DESC");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("City population from largest to smallest");
                while (rs.next()) {


                    String name = rs.getString("Name");
                    int population = rs.getInt("Population");

                    System.out.printf("Name: %s, Population: %d\n" , name , population);

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
