package DataStructures;

import java.util.Iterator;
import java.util.StringJoiner;

public class Hash implements TADVocabulary {

  public Hash() {

  }

  @Override
  public boolean add(String word) {
    return false;
  }

  @Override
  public boolean remove(String word) {
    return false;
  }

  @Override
  public boolean contains(String word) {
    return false;
  }

  @Override
  public boolean prefix(String prefix) {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  private class TADIterator implements Iterator<String> {

    private TADIterator() {

    }

    @Override
    public String next() {
      return null;
    }

    @Override
    public boolean hasNext() {
      return false;
    }
  }

  @Override
  public Iterator<String> iterator() {
    return new TADIterator();
  }

  @Override
  public String toString() {
    if (isEmpty()) return "[]";
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    for (String word : this) {
      sj.add(word);
    }
    return sj.toString();
  }
}
