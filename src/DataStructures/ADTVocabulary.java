package DataStructures;

/**
 * Interface per a definir el tipus abstracte de dades arbre TRIE.
 */
public interface ADTVocabulary {

  /**
   * Afegeix una paraula al arbre.
   * @param word paraula a afegir.
   */
  void add(String word);

  /**
   * Esborra una paraula del arbre.
   * @param word paraula a esborrar.
   */
  void remove(String word);

  /**
   * Retorna si una paraula existeix a l'arbre.
   * @param word paraula a buscar.
   * @return si la paraula existeix a l'arbre o no.
   */
  boolean contains(String word);

  /**
   * Retorna si l'arbre es buit.
   * @return si l'arbre es buit o no.
   */
  boolean isEmpty();
}
