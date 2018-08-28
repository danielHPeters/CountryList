package ch.peters.daniel.countrylist.factory;

/**
 * Factory interface.
 *
 * @param <T> Model class
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public interface Factory<T> {
  T createOneFromStringArray(String[] tokens);
}
