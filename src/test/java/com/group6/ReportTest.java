package com.group6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportTest {

    private Connection con = db_util.getTestConnection();
    private CountryService countryService;
    private Reports report;

    public ReportTest() throws SQLException {
    }


    @BeforeEach
    public void setUp() throws Exception {
        con = db_util.getTestConnection();
        Statement stmt = con.createStatement();

        /// Creating COUNTRY table...
        ///
        stmt.execute("CREATE TABLE country (Code VARCHAR(3) PRIMARY KEY NOT NULL , Name VARCHAR(50) NOT NULL, Continent VARCHAR(50) NOT NULL , Region VARCHAR(50) NOT NULL, SurfaceArea DOUBLE NOT NULL ,IndepYear INT, Population DOUBLE NOT NULL, LifeExpectancy DOUBLE, GNP DOUBLE NOT NULL, GNPOld DOUBLE, LocalName VARCHAR(50) NOT NULL, GovernmentForm VARCHAR(100) NOT NULL, HeadOfState VARCHAR(50), Capital INT, Code2 VARCHAR(2) NOT NULL)");
        stmt.execute("INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('ABW','Aruba','North America','Caribbean',193.00,NULL,103000,78.4,828.00,793.00,'Aruba','Nonmetropolitan Territory of The Netherlands','Beatrix',129,'AW')");
        stmt.execute("INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('AGO','Angola','Africa','Central Africa',1246700.00,1975,12878000,38.3,6648.00,7984.00,'Angola','Republic','José Eduardo dos Santos',56,'AO')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('AIA','Anguilla','North America','Caribbean',96.00,NULL,8000,76.1,63.20,NULL,'Anguilla','Dependent Territory of the UK','Elisabeth II',62,'AI')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('ALB','Albania','Europe','Southern Europe',28748.00,1912,3401200,71.6,3205.00,2500.00,'Shqipëria','Republic','Rexhep Mejdani',34,'AL')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('AND','Andorra','Europe','Southern Europe',468.00,1278,78000,83.5,1630.00,NULL,'Andorra','Parliamentary Coprincipality','',55,'AD')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('AZE','Azerbaijan','Asia','Middle East',86600.00,1991,7734000,62.9,4127.00,4100.00,'Azərbaycan','Republic','İlham Əliyev',144,'AZ')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('ANT','Netherlands Antilles','North America','Caribbean',800.00,NULL,217000,74.7,1941.00,NULL,'Nederlandse Antillen','Nonmetropolitan Territory of The Netherlands','Beatrix',33,'AN')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('BDI','Burundi','Africa','Eastern Africa',27834.00,1962,6695000,46.2,903.00,982.00,'Burundi/Uburundi','Republic','Pierre Buyoya',552,'BI')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES INSERT INTO `country` VALUES ('ARG','Argentina','South America','South America',2780400.00,1816,37032000,75.1,340238.00,323310.00,'Argentina','Federal Republic','Fernando de la Rúa',69,'AR')");
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES  ('ARM','Armenia','Asia','Middle East',29800.00,1991,3520000,66.4,1813.00,1627.00,'Hajastan','Republic','Robert Kotšarjan',126,'AM')");


        /// Creating CITY table
        ///
        stmt.execute("CREATE TABLE city (ID VARCHAR(3) PRIMARY KEY NOT NULL , Name VARCHAR(50) NOT NULL, CountryCode VARCHAR(3) NOT NULL , District VARCHAR(50) NOT NULL, Population DOUBLE NOT NULL)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (1,'Kabul','AFG','Kabol',1780000)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (2,'Qandahar','AFG','Qandahar',237500)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (3,'Herat','AFG','Herat',186800)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (4,'Mazar-e-Sharif','AFG','Balkh',127800)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (5,'Amsterdam','NLD','Noord-Holland',731200)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (6,'Rotterdam','NLD','Zuid-Holland',593321)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (7,'Haag','NLD','Zuid-Holland',440900)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (8,'Utrecht','NLD','Utrecht',234323)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (9,'Eindhoven','NLD','Noord-Brabant',201843)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (10,'Tilburg','NLD','Noord-Brabant',193238)");


        this.countryService = new CountryService(con);


    }


//    @Test
//    public void report1() throws Exception {
//        Reports report = new Reports();
//        report.allCitiesInContinent(con, "Asia");
//        assertEquals
//
//
//    }
}