package countryList.io;

import java.util.HashMap;

/**
 * Interface to be implemented by object that load data from different sources
 *
 * @author Daniel Peters
 */
public interface DataLoader {

    /**
     *
     * @return
     */
    public HashMap<String, String> load();

    /**
     *
     * @param source
     */
    public void setSource(String source);

}
