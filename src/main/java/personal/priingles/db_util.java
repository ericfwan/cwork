package personal.priingles;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * DATABASE CLASS
 * Contains all connections used throughout project
 *
 * **/
public class db_util {

    private Connection con = null;

    ///returns main mysql database connection
    ///
    public Connection getDbConnection() throws SQLException, InterruptedException {

        int retry2 = 7;
        System.out.println("Connecting to database...");

        //Thread.sleep(20000);
        for(int i = 0; i < retry2; i++){
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "example");

            if (connection != null){
                System.out.println("Connected");
                this.con = connection;
                break;
            }else{

                System.out.println("Connection Failed\n");
                Thread.sleep(10000);}
        }

        if(this.con == null){
            throw new SQLException("Failed to establish connection to the database");
        }

        return con;
    }

    ///returns test h2 database connection
    ///
    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
    }

    ///closes connection to database after use expires
    ///
    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Disconnected!");
            }
            catch (Exception e) {
                System.out.println("Failed to close!");
            }
        }
    }

}