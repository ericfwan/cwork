package com.napier.sem;

import java.sql.*;

public class topNCoun_Cont {
    public void run(int top, String cont){
        try {
            //db connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");


            if (con != null) { // connection integrity check
                String queryTop = ("SELECT * FROM country WHERE continent = '"+cont+"'  ORDER BY population DESC LIMIT " +top+ ";");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryTop);

                System.out.println("Top " +top+ " countries in " +cont);
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
