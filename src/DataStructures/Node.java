package DataStructures;

public class Node implements Comparable<Node> {
  private String word;
  private String info;

  public Node(String word) {
    this.word = word;
    this.info = "";
  }

  public void addInfo(String info) {
    if (this.info.length() == 0) this.info = info;
    else this.info += ", "+info;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Node && this.word.equals(((Node)obj).word);
  }

  @Override
  public int compareTo(Node o) {
    return this.word.compareTo(o.word);
  }

  @Override
  public String toString() {
    return word+" "+info;
  }
}
