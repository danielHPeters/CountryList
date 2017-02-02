package countryList.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * DataLoader that loads the data from a file source
 *
 * @author Daniel Peters
 */
public class FileLoader implements DataLoader {

    /**
     * The file containing the data
     */
    private String fileName;

    /**
     * Default constructor. Initializes the file name
     *
     * @param fileName
     */
    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Setter for the file name
     *
     * @param source
     */
    @Override
    public void setSource(String source) {
        this.fileName = source;
    }

    /**
     * Returns a HashMap containing the country codes and country names
     *
     * @return the completed HashMap
     */
    @Override
    public HashMap<String, String> load() {

        HashMap<String, String> map = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            String delimiter = ",";
            String[] result;

            while ((line = br.readLine()) != null) {

                result = line.split(delimiter);
                map.put(result[0], result[1]);

            }
        } catch (IOException e) {
            System.out.println("Fehler beim Einlesen der Datei.");
        }

        return map;
    }

}
