package countryList;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author d.peters
 */
public class SearchExecutor {

    /**
     * Cecks for User input in the Console
     */
    private final Scanner scanner;

    /**
     * This map contains the country code as key and the country name as value
     */
    private final HashMap<String, String> countryData;

    /**
     *
     * @param scanner
     * @param countryData
     */
    public SearchExecutor(Scanner scanner, HashMap<String, String> countryData) {

        this.scanner = scanner;
        this.countryData = countryData;

    }

    /**
     * Asks the user to input a three character country code and displays the
     * country name if it exists
     */
    public void searchCountry() {

        String input;
        String country;

        System.out.println("Please enter a country code");

        input = this.scanner.next().toUpperCase();
        country = this.countryData.get(input);

        if (country != null) {
            System.out.println("Countrycode: " + input + "\n"
                    + "Country name: " + country);
        } else {
            System.out.println("There is no country with the country code: "
                    + input + " !");
        }

    }

}
