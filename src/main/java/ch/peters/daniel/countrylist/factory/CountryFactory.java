package ch.peters.daniel.countrylist.factory;

import ch.peters.daniel.countrylist.model.Country;

/**
 * Country factory.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class CountryFactory implements Factory<Country> {
  @Override
  public Country createOneFromStringArray(String[] tokens) {
    return new Country(tokens[0], tokens[1], tokens[2]);
  }
}
