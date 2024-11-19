package com.napier.sem;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            App app = new App();

            countPopLtoS count = new countPopLtoS();
            count.run();
    }
}
