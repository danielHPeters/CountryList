package ch.peters.daniel.countrylist.factory;

import ch.peters.daniel.countrylist.model.Airport;

/**
 * Airport factory.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class AirportFactory implements Factory<Airport> {
  @Override
  public Airport createOneFromStringArray(String[] tokens) {
    return new Airport(tokens[0], tokens[1]);
  }
}
