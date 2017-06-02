package DataStructures;

import java.util.Iterator;
import java.util.StringJoiner;

public class GenericHashSet<E> implements ADTGenericHashSet<E>, Cloneable, Iterable<E> {
  private Node<E>[] table;
  private int size;
  private int numEle;

  @SuppressWarnings("unchecked")
  public GenericHashSet(int size) {
    if (size < 0) throw new IllegalArgumentException("Illegal Capacity: "+size);
    this.size = size;
    if (this.size == 0) this.size = 1;
    table = new Node[this.size];
    numEle = 0;
  }

  public GenericHashSet() {
    this(11);
  }

  @Override
  public void add(E e) {
    int pos = getPos(e);
    if (table[pos] == null) {
      table[pos] = new Node<>(e, null);
      numEle++;
    } else {
      Node<E> aux = table[pos];
      while (aux.next != null && !aux.ele.equals(e)) {
        aux = aux.next;
      }
      if (!aux.ele.equals(e)) {
        aux.next = new Node<>(e, null);
        numEle++;
      }
    }
    if (loadFactor() > 0.75) sizeExpand();
  }

  @Override
  public void remove(E e) {
    int pos = getPos(e);
    Node<E> aux = table[pos];
    if (aux.ele.equals(e)) {
      table[pos] = aux.next;
      numEle--;
    } else {
      while (aux.next != null && !aux.next.ele.equals(e)) {
        aux = aux.next;
      }
      if (aux.next != null && aux.next.ele.equals(e)) {
        aux.next = aux.next.next;
        numEle--;
      }
    }
    if (loadFactor() < 0.25) sizeShrink();
  }

  @Override
  public boolean contains(E e) {
    Node<E> aux = table[getPos(e)];
    while (aux != null && !aux.ele.equals(e)) {
      aux = aux.next;
    }
    return aux != null && aux.ele.equals(e);
  }

  @Override
  public int size() {
    return numEle;
  }

  @Override
  public boolean isEmpty() {
    return numEle == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new TADIterator();
  }

  @Override
  @SuppressWarnings("unchecked")
  public GenericHashSet<E> clone() {
    GenericHashSet<E> obj = null;
    try {
      obj = (GenericHashSet<E>) super.clone();
    } catch (CloneNotSupportedException e) {
      System.out.println(e.toString());
    }
    return obj;
  }

  @Override
  public String toString() {
    if (isEmpty()) return "[]";
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    for (E ele : this) {
      sj.add(ele.toString());
    }
    return sj.toString();
  }

  /**
   * Hash function, returns the position of the element.
   * @param e element to calc the position from.
   * @return returns the position of the element.
   */
  private int getPos(E e) {
    int hash = e.hashCode();
    if (hash < 0) hash *= -1;
    return hash % size;
  }

  /**
   * Calculates the load factor of the hash set.
   * @return a float corresponding to the load factor.
   */
  private float loadFactor() {
    return (float) numEle / size;
  }

  @SuppressWarnings("unchecked")
  private void sizeExpand() {
    GenericHashSet<E> oldHashSet = this.clone();
    size = size * 2 + 1;
    table = new Node[size];
    numEle = 0;
    for (E e : oldHashSet) add(e);
  }

  @SuppressWarnings("unchecked")
  private void sizeShrink() {
    GenericHashSet<E> oldHashSet = this.clone();
    size = size / 2;
    table = new Node[size];
    numEle = 0;
    for (E e : oldHashSet) add(e);
  }

  private class Node<E> {
    private E ele;
    private Node<E> next;

    Node(E ele, Node<E> next) {
      this.ele = ele;
      this.next = next;
    }
  }

  private class TADIterator implements Iterator<E> {
    private int index;
    private int count;
    private Node<E> node;

    private TADIterator() {
      index = 0;
      count = 0;
      node = null;
    }

    @Override
    public E next() {
      if (node == null) node = table[index++];
      else node = node.next;
      while (node == null) {
        node = table[index++];
      }
      count++;
      return node.ele;
    }

    @Override
    public boolean hasNext() {
      return count < numEle;
    }
  }
}
