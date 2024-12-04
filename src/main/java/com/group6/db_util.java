package com.group6;

import java.sql.*;

/**
 * DATABASE UTILITY CLASS
 * This class provides utility methods for establishing database connections to different environments (main database, IT, and test databases).
 * It also handles the closing of database connections after use.
 */
public class db_util {

    private Connection con = null; // Instance variable to hold the connection

    /**
     * Establishes a connection to the main MySQL database.
     * Retries a set number of times if the connection fails, with a delay between retries.
     *
     * @return A Connection object representing the connection to the main database.
     * @throws SQLException if the connection could not be established.
     * @throws InterruptedException if the thread is interrupted during the wait time between retries.
     */
    public Connection getDbConnection() throws SQLException, InterruptedException {
        int retryCount = 7;  // Number of retry attempts
        System.out.println("Connecting to the database...");

        Thread.sleep(20000);  // Initial delay before attempting the connection

        // Retry connection attempts a set number of times
        for (int i = 0; i < retryCount; i++) {
            // Try establishing a connection to the main MySQL database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://db:3306/world?useSSL=false", "root", "example"
            );

            // If the connection is successful, store it and break out of the loop
            if (connection != null) {
                System.out.println("Connected");
                this.con = connection;
                break;
            } else {
                // If the connection fails, print a message and retry after a delay
                System.out.println("Connection Failed\n");
                Thread.sleep(10000); // Wait before retrying
            }
        }

        // If no connection was established after all retries, throw an exception
        if (this.con == null) {
            throw new SQLException("Failed to establish connection to the database");
        }

        return con;  // Return the established connection
    }

    /**
     * Establishes a connection to the IT MySQL database.
     * Retries a set number of times if the connection fails, with a delay between retries.
     *
     * @return A Connection object representing the connection to the IT database.
     * @throws SQLException if the connection could not be established.
     * @throws InterruptedException if the thread is interrupted during the wait time between retries.
     */
    public Connection getITConnection() throws SQLException, InterruptedException {
        int retryCount = 7;  // Number of retry attempts
        System.out.println("Connecting to the IT database...");

        Thread.sleep(20000);  // Initial delay before attempting the connection

        // Retry connection attempts a set number of times
        for (int i = 0; i < retryCount; i++) {
            // Try establishing a connection to the IT MySQL database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example"
            );

            // If the connection is successful, store it and break out of the loop
            if (connection != null) {
                System.out.println("Connected");
                this.con = connection;
                break;
            } else {
                // If the connection fails, print a message and retry after a delay
                System.out.println("Connection Failed\n");
                Thread.sleep(10000);  // Wait before retrying
            }
        }

        // If no connection was established after all retries, throw an exception
        if (this.con == null) {
            throw new SQLException("Failed to establish connection to the database");
        }

        return con;  // Return the established connection
    }

    /**
     * Establishes a connection to an in-memory H2 test database.
     * This connection is used for testing purposes only.
     *
     * @return A Connection object representing the connection to the in-memory H2 test database.
     * @throws SQLException if the connection could not be established.
     */
    public static Connection getTestConnection() throws SQLException {
        // Return a connection to an in-memory H2 database
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
    }

    /**
     * Closes the current database connection.
     * This method should be called after the connection is no longer needed to free up resources.
     */
    public void disconnect() {
        if (con != null) {
            try {
                con.close();  // Attempt to close the connection
                System.out.println("Disconnected!");
            } catch (Exception e) {
                // If the connection could not be closed, print a failure message
                System.out.println("Failed to close!");
            }
        }
    }
}
