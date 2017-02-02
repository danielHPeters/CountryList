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
    private HashMap<String, String> countryData;
    
    /**
     * Search functionality
     */
    private SearchExecutor search;

    /**
     * Default constructor. Initializes the dataloader object.
     */
    public CountryList() {
        this.loader = new FileLoader("countries_simplified.csv");
        this.countryData = loader.load();
        this.scanner = new Scanner(System.in);
        this.search = new SearchExecutor(scanner, countryData);

    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryList pb = new CountryList();
        pb.search.searchCountry();
    }

}
