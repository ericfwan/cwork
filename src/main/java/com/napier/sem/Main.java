package com.napier.sem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create new Application instance
        App a = new App();

        // Connect to the database
        // UNCOMMENT THIS BACK ONCE IT'S READY a.connect();

        // Prompt user for query choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of top populated countries to fetch:");
        int N = scanner.nextInt();
        scanner.nextLine();  // consume the newline

        System.out.println("Enter the continent to filter by (or leave empty for all):");
        String continent = scanner.nextLine();

        // Get the top N countries by population in a continent (if provided)
   ArrayList<Country> countries = a.getTopNCountriesByPopulation(continent, N);

        // Print the result

        if (countries != null) {
            System.out.println("Top " + N + " countries fetched:");
            for (Country country : countries) {
                System.out.println(country.name + " - " + country.population);
            }
        }


        // Disconnect from the database
        a.disconnect();
    }
}