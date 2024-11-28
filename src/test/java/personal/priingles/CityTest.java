package personal.priingles;

import org.junit.jupiter.api.*;


import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;


public class CityTest {

    private Connection con;
    private CityService cityService;

    @BeforeEach
    public void setUp() throws Exception {
        con = db_util.getTestConnection();
        Statement stmt = con.createStatement();
        stmt.execute("CREATE TABLE city (ID INT PRIMARY KEY NOT NULL , Name VARCHAR(50) NOT NULL,  CountryCode VARCHAR(3) NOT NULL , District VARCHAR(50) NOT NULL, Population DOUBLE NOT NULL)");
        stmt.execute("INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (1,'Kabul','AFG','Kabol',1780000)");

        this.cityService = new CityService(con);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Statement stmt = con.createStatement();
        stmt.execute("DROP TABLE city;");

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
    public void getCitybyName() throws Exception {
        City city = cityService.getCity("Kabul");
        assertNotNull(city);
        assertEquals("Kabul", city.name);
        assertEquals(1780000, city.population);

    }





}
