package DataStructures;

/**
 * Interface per a definir el tipus abstracte de dades arbre TRIE.
 */
public interface TADTrie {

  /**
   * Afegeix una paraula al arbre.
   * @param word paraula a afegir.
   * @return si la paraula s'ha afegit correctament.
   */
  boolean add(String word);

  /**
   *
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
