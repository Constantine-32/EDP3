package DataStructures;

/**
 * Interface per a definir el tipus abstracte de dades arbre TRIE.
 */
public interface TADVocabulary {

  /**
   * Afegeix una paraula al arbre.
   * @param word paraula a afegir.
   * @return si la paraula s'ha afegit correctament.
   */
  boolean add(String word);

  /**
   * Esborra una paraula del arbre.
   * @param word paraula a esborrar.
   * @return si la paraula s'ha esborrat correctament.
   */
  boolean remove(String word);

  /**
   * Retorna si una paraula existeix a l'arbre.
   * @param word paraula a buscar.
   * @return si la paraula existeix a l'arbre o no.
   */
  boolean contains(String word);

  /**
   * Retorna si un prefix existeix a l'arbre.
   * @param prefix prefix a buscar.
   * @return si hi ha almenys una paraula que te el mateix prefix.
   */
  boolean prefix(String prefix);

  /**
   * Retorna si l'arbre es buit.
   * @return si l'arbre es buit o no.
   */
  boolean isEmpty();
}
