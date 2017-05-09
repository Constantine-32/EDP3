package Application;

import DataStructures.*;

public class Main {
  public static void main(String[] args) {
    StaticTrie staticTrie = new StaticTrie();

    staticTrie.add("home");
    staticTrie.add("homeworkers");
    staticTrie.add("homework");
    staticTrie.add("mountain");

    System.out.println(staticTrie.contains("homework"));
  }
}
