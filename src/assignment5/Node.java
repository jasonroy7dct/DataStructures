package assignment5;

public class Node implements Comparable<Node> {

  public int data;
  public Node left;
  public Node right;

  public Node() {
    this.data = 0;
    this.left = null;
    this.right = null;
  }

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public int compareTo(Node node) {
    return Integer.compare(this.data, node.data);
  }
}
