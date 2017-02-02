package countryList.io;

import java.util.HashMap;

/**
 * Interface to be implemented by object that load data from different sources
 *
 * @author Daniel Peters
 */
public interface DataLoader {

    /**
     * Loads the data into a HashMap
     * @return
     */
    public HashMap<String, String> load();

    /**
     * Set the source of the data
     * @param source
     */
    public void setSource(String source);

}
