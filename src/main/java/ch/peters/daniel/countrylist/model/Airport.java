package ch.peters.daniel.countrylist.model;

import java.io.Serializable;

/**
 * Airport model class.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class Airport implements Serializable {
  private String code;
  private String name;

  public Airport(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return code + ',' + name;
  }
}
