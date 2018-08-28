package ch.peters.daniel.countrylist.io;

import ch.peters.daniel.countrylist.factory.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DataHandler that loads the data from a file source
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class FileHandler<T> implements DataHandler<T> {
  private static final String DELIMITER = ",";
  private String source;
  private Factory<T> factory;

  public FileHandler(String source, Factory<T> factory) {
    this.source = source;
    this.factory = factory;
  }

  /**
   * Returns a HashMap containing the country codes and country names.
   *
   * @return The completed HashMap
   */
  public List<T> getAll() {
    var objects = new ArrayList<T>();
    var inputStream = getClass().getResourceAsStream(source);

    try (var reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      reader.lines().forEach(line -> objects.add(factory.createOneFromStringArray(line.split(DELIMITER))));
    } catch (IOException e) {
      System.out.println("Failed to open the data file: " + source + ".");
    }

    return objects;
  }

  @Override
  public void put(List<T> entities) {
    try {
      var entityStrings = entities.stream().map(T::toString).collect(Collectors.toList());
      var url = getClass().getResource(source);

      Files.write(Paths.get(url.getPath()), entityStrings);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getSource() {
    return source;
  }

  @Override
  public void setSource(String source) {
    this.source = source;
  }
}
