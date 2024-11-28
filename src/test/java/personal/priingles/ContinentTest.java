package personal.priingles;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ContinentTest {

    @Test
    public void testDisplayContinent() throws Exception {


        Continent cont = new Continent("Nowhere");
        cont.name = "Nowhere";

        ArrayList<Country> countries = new ArrayList<>();
        int pop = 0;
        while(pop < 20) {
            Country country = new Country();
            country.name = "Non";
            country.population = pop;
            country.code = "NNN";
            country.continent = "Nowhere";
            pop++;

            countries.add(country);
        }

        cont.countries = countries;

        String[] a = {"Nowhere", "20"};
        String[] actual = cont.displayContinent();
        assertArrayEquals(a,actual);
    }

}