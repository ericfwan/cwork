package com.napier.sem;

import java.sql.*;

public class topNCoun_Wrld {
    public void run(App app, int top){
        try {
            //db connection
            Connection con = app.connectToDatabase();

            if (con != null) { // connection integrity check
                String queryTop = ("SELECT * FROM country ORDER BY population DESC LIMIT " +top+ ";");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryTop);

                System.out.println("Top " + top + " countries in the world");
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
