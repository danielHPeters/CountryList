package ch.peters.daniel.countrylist;

import ch.peters.daniel.countrylist.factory.AirportFactory;
import ch.peters.daniel.countrylist.factory.CountryFactory;
import ch.peters.daniel.countrylist.io.FileHandler;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Read csv file with List of countries Gets the country that the user
 * specifies with country code.
 *
 * @author Daniel Peters
 * @version 2.0
 */
public class App extends Application {
  public void test() {
    var countryFactory = new CountryFactory();
    var countryLoader = new FileHandler<>("/data/countries.csv", countryFactory);
    var countryData = countryLoader.getAll();
    var airportFactory = new AirportFactory();
    var airportLoader = new FileHandler<>("/data/airports.csv", airportFactory);
    var airportData = airportLoader.getAll();

    countryData.forEach(System.out::println);
    airportData.forEach(System.out::println);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    var root = FXMLLoader.<Parent>load(getClass().getResource("/view/screen_main.fxml"));
    var decorator = new JFXDecorator(primaryStage, root);
    decorator.setCustomMaximize(true);

    primaryStage.setTitle("Country List");
    primaryStage.setScene(new Scene(decorator));
    primaryStage.show();
  }

  /**
   * Main method
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
