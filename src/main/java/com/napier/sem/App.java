package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    private Connection con = null;

    public static void main(String[] args) {
        App app = new App();

        // Connect to the database
        app.connect();

        // Example usage: Get top 5 countries by population in Asia
        ArrayList<Country> countries = app.getTopNCountriesByPopulation("Asia", 5);

        // Display the results
        if (countries != null) {
            for (Country country : countries) {
                System.out.println(country.getName() + " - Population: " + country.getPopulation());
            }
        }

        // Disconnect from the database
        app.disconnect();
    }

    public void connect() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database driver loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Attempt to connect to the database with retries
        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for the database to start
                Thread.sleep(30000);

                // Connect to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Successfully connected to the database.");

                break;
            } catch (SQLException | InterruptedException e) {
                System.out.println("Failed to connect to the database. Attempt " + (i + 1));
            }
        }
    }

    public ArrayList<Country> getTopNCountriesByPopulation(String continent, int n) {
        ArrayList<Country> countries = new ArrayList<>();

        try {
            if (con == null) {
                System.out.println("No active database connection.");
                return null;
            }

            // Query to get top N countries by population in a specific continent
            String query = "SELECT Name, Population FROM Country WHERE Continent = ? ORDER BY Population DESC LIMIT ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, continent);
            stmt.setInt(2, n);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                int population = rs.getInt("Population");
                countries.add(new Country(name, population));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Database query error: " + e.getMessage());
        }

        return countries;
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Disconnected from the database.");
            } catch (SQLException e) {
                System.out.println("Error closing connection to database: " + e.getMessage());
            }
        }
    }
}
