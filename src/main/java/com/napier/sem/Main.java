package com.napier.sem;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            App app = new App();


            coun_World count = new coun_World();
            count.run();

            coun_Cont count2 = new coun_Cont();
            count2.run("Asia");

            coun_Reg count3 = new coun_Reg();
            count3.run("Western Africa");

            topNCoun_Wrld count4 = new topNCoun_Wrld();
            count4.run(3);

            topNCoun_Cont count5 = new topNCoun_Cont();
            count5.run(4, "Asia");

            topNCoun_Reg count6 = new topNCoun_Reg();
            count6.run(5, "Western Africa");

            city_World count7 = new city_World();
            count7.run();

            city_Cont count8 = new city_Cont();
            count8.run("Asia");

            city_Reg count9 = new city_Reg();
            count9.run("Western Africa");

            city_Coun count10 = new city_Coun();
            count10.run("Nigeria");

            city_Dist count11 = new city_Dist();
            count11.run("Gelderland");

    }
}
