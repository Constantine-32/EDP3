package DataStructures;

public class StaticTrie implements TADTrie {
  private static String LETTERS = "abcdefghijklmnopqrstuvwxyz";
  private StaticTrie[] children;
  private int numChildren;
  private boolean isWord;

  public StaticTrie() {
    children = new StaticTrie[LETTERS.length()];
    numChildren = 0;
    isWord = false;
  }

  @Override
  public boolean add(String word) {
    char first = word.charAt(0);
    int index = LETTERS.indexOf(first);

    StaticTrie child = children[index];

    if (child == null) {
      child = new StaticTrie();
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
  public boolean contains(String word) {
    StaticTrie node = this;
    for (int i = 0; i < word.length(); i++) {
      int index = LETTERS.indexOf(word.charAt(i));
      node = node.children[index];
      if (node == null) {
        return false;
      }
    }
    return node.isWord;
  }

  @Override
  public boolean isEmpty() {
    return numChildren == 0;
  }
}
