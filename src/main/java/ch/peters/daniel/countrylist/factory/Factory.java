package ch.peters.daniel.countrylist.factory;

/**
 * Factory interface.
 *
 * @param <T> Model class
 * @author Daniel Peters
 * @version 1.0
 */
public interface Factory<T> {
  T createOneFromStringArray(String[] tokens);
}
