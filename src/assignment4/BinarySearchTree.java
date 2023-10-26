package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

  public static class Node {

    /**
     * You are given an input ASCII text file containing an arbitrary number of student records in
     * the following format: Operation code: 1 character ('I' for insert, 'D' for delete) Student
     * number: 7 characters Student last name: 25 characters Home department: 4 characters Program:
     * 4 characters Year: 1 character Each record is stored as one line in the text file; i.e.,
     * there is a newline character immediately following the year.
     */

    // 7 characters
    private String studentNumber;
    // 25 characters
    private String studentLastName;
    // 4 characters
    private String homeDepartment;
    // 4 characters
    private String program;
    // 1 character
    private int year;
    private Node left;
    private Node right;

    public Node(String studentNumber, String studentLastName, String homeDepartment, String program,
        int year) {
      this.studentNumber = studentNumber;
      this.studentLastName = studentLastName;
      this.homeDepartment = homeDepartment;
      this.program = program;
      this.year = year;
    }
  }

  public Node root;

  public Node insert(Node root, String studentNumber, String studentLastName, String homeDepartment,
      String program, int year, Comparator<Node> comparator) {
    if (root == null) {
      return new Node(studentNumber, studentLastName, homeDepartment, program, year);
    }

    int comparison = comparator.compare(
        new Node(studentNumber, studentLastName, homeDepartment, program, year), root);

    if (comparison < 0) {
      root.left = insert(root.left, studentNumber, studentLastName, homeDepartment, program, year,
          comparator);
    } else if (comparison > 0) {
      root.right = insert(root.right, studentNumber, studentLastName, homeDepartment, program, year,
          comparator);
    }
    return root;
  }

  public Node delete(Node root, String studentLastName, Comparator<Node> comparator) {
    if (root == null) {
      return null;
    }

    int comparison = comparator.compare(new Node("", studentLastName, "", "", 0), root);

    if (comparison < 0) {
      root.left = delete(root.left, studentLastName, comparator);
    } else if (comparison > 0) {
      root.right = delete(root.right, studentLastName, comparator);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        root.studentLastName = inOrderSuccessor(root.right);
        root.right = delete(root.right, root.studentLastName, comparator);
      }
    }
    return root;
  }


  public static class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
      int lastNameComparison = node1.studentLastName.compareToIgnoreCase(node2.studentLastName);
      if (lastNameComparison == 0) {
        return node1.studentNumber.compareTo(node2.studentNumber);
      }
      return lastNameComparison;
    }
  }

  public void buildBinarySearchTreeFromTextFile(String fileName) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String operationCode = line.substring(0, 1);
      String studentNumber = line.substring(1, 8);
      String studentLastName = line.substring(8, 33).trim();
      String homeDepartment = line.substring(33, 37);
      String program = line.substring(37, 41);
      int year = Integer.parseInt(line.substring(41, 42));

      // Use case-insensitive comparison for studentLastName
      Comparator<Node> comparator = new NodeComparator().thenComparing(
          (node1, node2) -> node1.studentLastName.compareToIgnoreCase(node2.studentLastName)
      );

      if (operationCode.equals("I")) {
        // Insert the student data into the BST
        root = insert(root, studentNumber, studentLastName, homeDepartment, program, year,
            comparator);
      } else if (operationCode.equals("D")) {
        // Delete the student data from the BST
        root = delete(root, studentLastName, comparator);
      }
    }
    bufferedReader.close();
  }

  // depth-first traversal
  public List<Node> inOrderTraversal() throws IOException {
    FileWriter fileWriter = new FileWriter("src/assignment4/textfile/task-2_inOrderTraversal.txt");
    List<Node> nodeList = new ArrayList<>();
    inOrderTraversalToFile(root, nodeList, fileWriter);
    fileWriter.flush();
    fileWriter.close();
    return nodeList;
  }

  private void inOrderTraversalToFile(Node node, List<Node> nodeList, FileWriter fileWriter)
      throws IOException {
    if (node != null) {
      inOrderTraversalToFile(node.left, nodeList, fileWriter);
      // write the data to the file
      fileWriter.write(node.studentNumber + " " + node.studentLastName + " " + node.homeDepartment
          + " " + node.program + " " + node.year + "\n");
      nodeList.add(node);
      inOrderTraversalToFile(node.right, nodeList, fileWriter);
    }
  }

  public List<Node> preOrderTraversal() {
    List<Node> nodeList = new ArrayList<>();
    preOrderTraversal(root, nodeList);
    return nodeList;
  }

  private void preOrderTraversal(Node node, List<Node> nodeList) {
    if (node != null) {
      nodeList.add(node);
      preOrderTraversal(node.left, nodeList);
      preOrderTraversal(node.right, nodeList);
    }
  }

  public List<Node> postOrderTraversal() {
    List<Node> nodeList = new ArrayList<>();
    postOrderTraversal(root, nodeList);
    return nodeList;
  }

  private void postOrderTraversal(Node node, List<Node> nodeList) {
    if (node != null) {
      postOrderTraversal(node.left, nodeList);
      postOrderTraversal(node.right, nodeList);
      nodeList.add(node);
    }
  }

  // breadth-first traversal
  public List<Node> levelOrderTraversal() throws IOException {
    FileWriter fileWriter = new FileWriter(
        "src/assignment4/textfile/task-3_levelOrderTraversal.txt");
    List<Node> nodeList = new ArrayList<>();
    levelOrderTraversalToFile(root, nodeList, fileWriter);
    fileWriter.flush();
    fileWriter.close();
    return nodeList;
  }

  private void levelOrderTraversalToFile(Node root, List<Node> nodeList, FileWriter fileWriter)
      throws IOException {
    if (root == null) {
      return;
    }

    // initial queue
    Queue<Node> queue = new LinkedList<>();
    // add root in the queue
    queue.offer(root);

    // traversal the rest nodes
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      nodeList.add(node);

      // enqueue the left child if exists
      if (node.left != null) {
        queue.offer(node.left);
      }
      // enqueue the right child if exists
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    // write the data to the file
    for (Node node : nodeList) {
      fileWriter.write(
          node.studentNumber + " " + node.studentLastName + " " +
              node.homeDepartment + " " + node.program + " " + node.year + "\n");
    }
  }

  private String inOrderSuccessor(Node root) {
    String min = root.studentLastName;
    while (root.left != null) {
      min = root.left.studentLastName;
      root = root.left;
    }
    return min;
  }
}
