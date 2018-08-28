package ch.peters.daniel.countrylist.controller;

import ch.peters.daniel.countrylist.factory.CountryCellFactory;
import ch.peters.daniel.countrylist.factory.CountryFactory;
import ch.peters.daniel.countrylist.io.FileHandler;
import ch.peters.daniel.countrylist.model.Country;
import ch.peters.daniel.countrylist.search.Search;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  @FXML
  private JFXTextField search;
  @FXML
  private JFXButton btnStartSearch;
  @FXML
  private JFXListView<Country> entitiesList;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    var countryFactory = new CountryFactory();
    var countryLoader = new FileHandler<>("/data/countries_simplified.csv", countryFactory);
    var observableList = FXCollections.observableArrayList(countryLoader.getAll());

    entitiesList.setItems(observableList);
    entitiesList.setCellFactory(new CountryCellFactory());

    btnStartSearch.setOnAction(event -> {
      var term = search.getText();
      entitiesList.setItems(Search.search(observableList, term));
    });
  }
}
