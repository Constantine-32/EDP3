package DataStructures;

public class Trie implements ADTVocabulary {
  private Trie[] children;
  private boolean isWord;

  public Trie() {
    children = new Trie[26];
    isWord = false;
  }

  @Override
  public void add(String word) {
    int index = word.charAt(0) - 'a';

    Trie child = children[index];

    if (child == null) {
      child = new Trie();
      children[index] = child;
    }

    if (word.length() == 1) {
      child.isWord = true;
    } else {
      child.add(word.substring(1));
    }
  }

  @Override
  public void remove(String word) {

  }

  @Override
  public boolean contains(String word) {
    Trie aux = getNode(word);
    return aux != null && aux.isWord;
  }

  @Override
  public boolean isEmpty() {
    for (Trie aChildren : children) {
      if (aChildren != null) return false;
    }
    return true;
  }

  public boolean prefix(String prefix) {
    Trie aux = getNode(prefix);
    return aux != null;
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
}
