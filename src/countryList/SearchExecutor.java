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
     * 
     */
    private final HashMap<String, String> countryData;
    
    /**
     * 
     * @param scanner
     * @param countryData 
     */
    public SearchExecutor(Scanner scanner, HashMap<String, String> countryData){
        
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

        System.out.println("Bitte gib einen Ländercode ein");

        input = this.scanner.next().toUpperCase();
        country = this.countryData.get(input);

        if (country != null) {
            System.out.println("Ländercode: " + input + "\nLändername: " + country);
        } else {
            System.out.println("Es gibt kein land mit dem code: " + input + " !");
        }

    }
    
}
