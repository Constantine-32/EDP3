package DataStructures;

import java.util.Iterator;
import java.util.StringJoiner;

public class Trie implements TADVocabulary {
  private Trie[] children;
  private int numChildren;
  private boolean isWord;

  public Trie() {
    children = new Trie[26];
    numChildren = 0;
    isWord = false;
  }

  @Override
  public boolean add(String word) {
    int index = word.charAt(0) - 'a';

    Trie child = children[index];

    if (child == null) {
      child = new Trie();
      children[index] = child;
      numChildren++;
    }

    if (word.length() == 1) {
      if (child.isWord) {
        return false;
      }
      child.isWord = true;
      return true;
    } else return child.add(word.substring(1));
  }

  @Override
  public boolean remove(String word) {
    return false;
  }

  /**
   * Retorna la referencia a l'ultim node de la string indicada,
   * si aquesta no existeix retorna null.
   * @param string String a buscar.
   * @return Trie corresponent a l'ultim caracter de la string indicada.
   */
  private Trie getNode(String string) {
    Trie aux = this;
    for (int i = 0; i < string.length(); i++) {
      int index = string.charAt(i) - 'a';
      aux = aux.children[index];
      if (aux == null) return null;
    }
    return aux;
  }

  @Override
  public boolean contains(String word) {
    Trie aux = getNode(word);
    return aux != null && aux.isWord;
  }

  @Override
  public boolean prefix(String prefix) {
    Trie aux = getNode(prefix);
    return aux != null;
  }

  @Override
  public boolean isEmpty() {
    return numChildren == 0;
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
