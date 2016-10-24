/*
 * Read csv file with hashmap of countries
 * Gets the country that the user specifies with countrycode.
 */
package countryList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Daniel
 * @version 1.0
 */
public class CountryList {

    /*------------*/
    /* Attributes */
    /*------------*/
    
    private HashMap<String, String> map = new HashMap<>();

    /*---------------------*/
    /* Getters and Setters */
    /*---------------------*/
    
    /**
     * 
     * @return 
     */
    public HashMap<String, String> getMap() {
        return map;
    }

    /**
     * 
     * @param map 
     */
    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    /*---------*/
    /* Methods */
    /*---------*/
    
    /**
     * 
     * @param msg 
     */
    public void cOut(String msg) {
        System.out.println(msg);
    }

    /**
     * 
     * @param fileName 
     */
    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String delimiter = ",";
            String[] result;
            HashMap<String, String> m = new HashMap();
            while ((line = br.readLine()) != null) {
                result = line.split(",");
                m.put(result[0], result[1]);
            }
            setMap(m);
        } catch (IOException e) {
            cOut("Fehler beim Einlesen der Datei.");
        }
    }

    /**
     * 
     */
    public void searchCountry() {
        HashMap<String, String> data;
        String input;
        String airport;
        Scanner scanner = new Scanner(System.in);

        String file = "countries_simplified.csv";
        readFile(file);
        data = getMap();
        cOut("Bitte gib einen Ländercode ein");
        input = scanner.next().toUpperCase();
        airport = data.get(input);
        if (airport != null) {
            cOut("Ländercode: " + input + "\nLändername: " + airport);
        } else {
            cOut("Es gibt kein land mit dem code: " + input + " !");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryList pb = new CountryList();
        pb.searchCountry();
    }

}
