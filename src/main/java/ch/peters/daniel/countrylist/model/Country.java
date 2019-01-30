package ch.peters.daniel.countrylist.model;

import java.io.Serializable;

/**
 * Country model class.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Country implements Serializable {
  private String isoCode;
  private String name;
  private String capital;

  public Country(String isoCode, String name, String capital) {
    this.isoCode = isoCode;
    this.name = name;
    this.capital = capital;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  @Override
  public String toString() {
    return isoCode + ',' + name + ',' + capital;
  }
}
