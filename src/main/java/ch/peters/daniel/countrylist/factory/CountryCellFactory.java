package ch.peters.daniel.countrylist.factory;

import ch.peters.daniel.countrylist.model.Country;
import ch.peters.daniel.countrylist.view.CountryCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Cell factory for country cell components.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class CountryCellFactory implements Callback<ListView<Country>, ListCell<Country>> {
  @Override
  public ListCell<Country> call(ListView<Country> param) {
    return new CountryCell();
  }
}
