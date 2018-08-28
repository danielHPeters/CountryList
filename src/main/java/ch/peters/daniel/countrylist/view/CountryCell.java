package ch.peters.daniel.countrylist.view;

import ch.peters.daniel.countrylist.model.Country;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class CountryCell extends ListCell<Country> {
  @FXML
  private Label labelIsoCode;
  @FXML
  private Label labelName;
  @FXML
  private Label labelCapital;

  public CountryCell() {
    loadView();
  }

  private void loadView() {
    try {
      var loader = new FXMLLoader(getClass().getResource("/view/component/cell_country.fxml"));
      loader.setController(this);
      loader.setRoot(this);
      loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void updateItem(Country item, boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
      setText(null);
      setContentDisplay(ContentDisplay.TEXT_ONLY);
    } else {
      labelIsoCode.setText(item.getIsoCode());
      labelName.setText(item.getName());
      labelCapital.setText(item.getCapital());

      setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
  }
}
