package DataStructures;

/**
 * Interface per definir el tipus abstracte de dades Set de Hash.
 * @param <E> tipus d'elements a guardar.
 */
public interface ADTGenericHashSet<E> extends Iterable<E> {

  /**
   * Afegeix un element a la taula.
   * @param e element a afegir.
   */
  void add(E e);

  /**
   * Elimina un element de la taula.
   * @param e element a eliminar.
   */
  void remove(E e);

  /**
   * Retorna si un element existeix a la taula.
   * @param e element a buscar.
   * @return si l'element existeix a la taula o no.
   */
  boolean contains(E e);

  /**
   * Retorna el nombre d'elements que conte la taula.
   * @return el nombre d'elements que conte la taula.
   */
  int size();

  /**
   * Retorna si la taula es buida.
   * @return si la taula es buida o no.
   */
  boolean isEmpty();
}
