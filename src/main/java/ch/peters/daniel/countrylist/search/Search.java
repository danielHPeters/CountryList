package ch.peters.daniel.countrylist.search;

import javafx.collections.ObservableList;

/**
 * Searches the csv files.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Search {
  /**
   * Search a list for objects which have the search term in it when converted to string.
   *
   * @param objects List of objects
   * @param term    Search term
   * @return List of matching objects
   */
  public static <T> ObservableList<T> search(ObservableList<T> objects, String term) {
    return objects.filtered(entity -> entity.toString().toLowerCase().contains(term.toLowerCase()));
  }
}
