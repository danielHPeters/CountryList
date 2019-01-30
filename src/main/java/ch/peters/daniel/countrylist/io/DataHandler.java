package ch.peters.daniel.countrylist.io;

import java.util.List;

/**
 * Interface to be implemented by object that getAll data from different sources
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface DataHandler<T> {
  List<T> getAll();

  void put(List<T> data);

  String getSource();

  void setSource(String source);
}
