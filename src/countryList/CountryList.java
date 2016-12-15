package countryList;

import countryList.io.DataLoader;
import countryList.io.FileLoader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Read csv file with hashmap of countries Gets the country that the user
 * specifies with countrycode.
 *
 * @author Daniel Peters
 * @version 2.0
 */
public class CountryList {

    /**
     * Loads data from a source
     */
    private final DataLoader loader;

    /**
     * Scanner for console user input
     */
    private final Scanner scanner;

    /**
     * HashMap containing three character country codes as key and the name of
     * the country as value
     */
    private HashMap<String, String> map;

    /**
     * Default constructor. Initializes the dataloader object.
     */
    public CountryList() {
        this.loader = new FileLoader("countries_simplified.csv");
        this.map = new HashMap<>();
        this.scanner = new Scanner(System.in);

    }

    /**
     * Asks the user to input a three character country code and displays the
     * country name if it exists
     */
    public void searchCountry() {

        String input;
        String country;

        this.map = loader.load();

        System.out.println("Bitte gib einen Ländercode ein");

        input = this.scanner.next().toUpperCase();
        country = this.map.get(input);

        if (country != null) {
            System.out.println("Ländercode: " + input + "\nLändername: " + country);
        } else {
            System.out.println("Es gibt kein land mit dem code: " + input + " !");
        }

    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryList pb = new CountryList();
        pb.searchCountry();
    }

}
