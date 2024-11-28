package personal.priingles;

import org.junit.jupiter.api.*;


import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CountryTest {

    private Connection con;
    private CountryService countryService;

    @BeforeEach
    public void setUp() throws Exception {
        con = db_util.getTestConnection();
        Statement stmt = con.createStatement();
        stmt.execute("CREATE TABLE country (Code VARCHAR(3) PRIMARY KEY NOT NULL , Name VARCHAR(50) NOT NULL, Continent VARCHAR(50) NOT NULL , Region VARCHAR(50) NOT NULL, SurfaceArea DOUBLE NOT NULL ,IndepYear INT, Population DOUBLE NOT NULL, LifeExpectancy DOUBLE, GNP DOUBLE NOT NULL, GNPOld DOUBLE, LocalName VARCHAR(50) NOT NULL, GovernmentForm VARCHAR(100) NOT NULL, HeadOfState VARCHAR(50), Capital INT, Code2 VARCHAR(2) NOT NULL)");
        stmt.execute("INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('AGO','Angola','Africa','Central Africa',1246700.00,1975,12878000,38.3,6648.00,7984.00,'Angola','Republic','José Eduardo dos Santos',56,'AO')") ;
        stmt.execute("INSERT INTO  country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadofState, Capital, Code2) VALUES ('BFA','Burkina Faso','Africa','Western Africa',274000.00,1960,11937000,46.7,2425.00,2201.00,'Burkina Faso','Republic','Blaise Compaoré',549,'BF')");

        this.countryService = new CountryService(con);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Statement stmt = con.createStatement();
        stmt.execute("DROP TABLE country;");

        if(con != null) {
            con.close();
        }
    }


    @Test
    public void testDisplayCountry() {

        Country country = new Country();
        country.name = "Non";
        country.population = 2;
        country.code = "NNN";
        country.continent = "Nowhere";


        String[] a = {"NNN", "Non", "Nowhere", "2"};
        String[] actual = country.displayCountry();

        assertArrayEquals(a, actual);

    }

    @Test
    public void getCountrybyName() throws Exception {
        Country country = countryService.getCountry_Name("Angola");
        assertNotNull(country);
        assertEquals("Angola", country.name);
        assertEquals(12878000, country.population);

    }
    /**
    @Test
    public void getCountrybyContinent() throws Exception {
        ArrayList<Country> countries = countryService.getCountry_Continent("Europe");
        Country[] countriesArray = countries.toArray(new Country[countries.size()]);
        assertNotNull(countriesArray);
        assertArrayEquals(2, countriesArray.length);
    }**/





}
