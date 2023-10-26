import assignment2.Queue;
import assignment2.Stack;
import assignment2.Task2;
import assignment2.Task4StackWithTwoQs;
import assignment3.HashTable;
import assignment4.BinarySearchTree;
import assignment5.BSTToHeapTransformer;
import assignment5.HeapBuilder;
import assignment5.Node;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    // Assignment2 Task-1
    System.out.println("Task-1");
    Stack<Integer> stack = new Stack<>(3);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    // the capacity is 3, so if push an element into it, the exception will be thrown
    try {
      stack.push(4);
    } catch (IllegalStateException exception) {
      System.out.println(exception);
    }
    System.out.println("Is the stack full? " + stack.isFull());
    System.out.println("Is the stack empty? " + stack.isEmpty());
    System.out.println("The stack size is " + stack.size());
    System.out.println("Peeked element(latest element): " + stack.peek());
    System.out.println("Popped element(last pushed element): " + stack.pop());
    System.out.println("Popped element(second pushed element): " + stack.pop());
    System.out.println("Popped element(first pushed element): " + stack.pop());
    System.out.println("Is the stack full? " + stack.isFull());
    System.out.println("Is the stack empty? " + stack.isEmpty());

    // if capacity <= 0
    try {
      new Stack<>(-1);
    } catch (IllegalArgumentException exception) {
      System.out.println(exception);
    }

    // Assignment2 Task-2
    System.out.println("Task-2");
    Task2 task2 = new Task2();
    int output1 = task2.caculateTheArithmeticExpression("10 + 20 * 2");
    System.out.println(
        "Assignment2 Task-2 Input: str = \"10 + 20 * 2\", output should be 50: " + output1);
    try {
      task2.caculateTheArithmeticExpression("foo / 30 + 7");
    } catch (UnsupportedOperationException exception) {
      System.out.println(
          "Assignment2 Task-2 Input: str = \"foo / 30 + 7\", output should be NaN: " + exception);
    }

    // Assignment2 Task-3
    System.out.println("Task-3");
    Queue<Integer> queue = new Queue<>();
    System.out.println("Is the queue empty? " + queue.isEmpty());

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println("Is the queue empty after enqueue? " + queue.isEmpty());
    System.out.println("This queue size is : " + queue.size());
    System.out.println("Polled element(first element): " + queue.poll());
    System.out.println("Dequeued element(first element): " + queue.dequeue());
    System.out.println("Dequeued element(second element): " + queue.dequeue());
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    System.out.println(
        "This queue size is after dequeue 2 elements and enqueue 3 elements : " + queue.size());
    System.out.println("Dequeued element(current first element): " + queue.dequeue());

    // Assignment2 Task-4
    System.out.println("Task-4");
    Task4StackWithTwoQs stackWithTwoQs = new Task4StackWithTwoQs();
    stackWithTwoQs.push(1);
    stackWithTwoQs.push(2);
    stackWithTwoQs.push(3);

    // it is stack, so it will be LIFO
    System.out.println("Pop element(latest element): " + stackWithTwoQs.pop()); //3
    System.out.println("Peek element(latest element after pop): " + stackWithTwoQs.peek()); //2
    System.out.println("This stackWithTwoQs size is : " + stackWithTwoQs.size()); //2

    stackWithTwoQs.push(4);
    stackWithTwoQs.push(5);

    System.out.println("Pop element(latest element): " + stackWithTwoQs.pop()); //5
    System.out.println("Peek element(latest element after pop): " + stackWithTwoQs.peek()); //4
    System.out.println("This stackWithTwoQs size is : " + stackWithTwoQs.size()); //3

    // Assignment3 Task-1
    System.out.println("Task-1");
    HashTable hashTable = new HashTable(10);
    hashTable.insert("A", "a");
    hashTable.insert("B", "b");
    hashTable.insert("C", "c");
    hashTable.insert("D", "d");
    hashTable.insert("E", "e");

    System.out.println("This hashTable size is : " + hashTable.size()); //5
    System.out.println("Value of A is : " + hashTable.get("A")); //a
    System.out.println("Value of B is : " + hashTable.get("B")); //b
    System.out.println("Value of C is : " + hashTable.get("C")); //c
    System.out.println("Value of D is : " + hashTable.get("D")); //d
    System.out.println("Value of E is : " + hashTable.get("E")); //e

    hashTable.insert("A", "aaa");
    System.out.println("Updated value of A is : " + hashTable.get("A")); //aaa

    System.out.println("Empty key : " + hashTable.get("Z")); //null

//    // Assignment3 Task-2
//    System.out.println("Task-2");
//    Task2 task2 = new Task2();
//    int numberOfUniqueAnagramRoots = task2.findTheNumberOfUniqueAnagramRoots(
//        "src/assignment3/textfile/test.txt");
//    System.out.println("Number of unique anagram roots is: " + numberOfUniqueAnagramRoots);

    // Assignment 4: Task-1
    System.out.println("Task-1");
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.buildBinarySearchTreeFromTextFile("src/assignment4/textfile/tree-input.txt");
    System.out.println("tree-input.txt inputted");

    // Assignment 4: Task-2
    System.out.println("Task-2");
    System.out.println("task-2_inOrderTraversal.txt generated");
    binarySearchTree.inOrderTraversal(); // output file as task-2_inOrderTraversal.txt
    // Assignment 4: Task-3
    System.out.println("Task-3");
    System.out.println("task-2_levelOrderTraversal.txt generated");
    binarySearchTree.levelOrderTraversal(); // output file as task-2_levelOrderTraversal.txt

    // Assignment 5: Task-1
    System.out.println("Task-1");
    System.out.println("Example 1");
    HeapBuilder heapBuilder = new HeapBuilder();
    List<Integer> list = Arrays.asList(10, 30, 5, 2, 1, 13);
    Node minHeapNode = heapBuilder.createMinHeap(list);
    System.out.println("Min Heap root should be 1: " + minHeapNode.getData());
    Node maxHeapNode = heapBuilder.createMaxHeap(list);
    System.out.println("Max Heap root should be 30: " + maxHeapNode.getData());
    System.out.println("Example 2");
    List<Integer> integers = Arrays.asList(11, 3232, 43, 455, 4, 13, 12424345, 2, 13232);
    Node minHeap = heapBuilder.createMinHeap(integers);
    System.out.println("Min Heap root should be 2: " + minHeap.getData());
    Node maxHeap = heapBuilder.createMaxHeap(integers);
    System.out.println("Max Heap root should be 12424345: " + maxHeap.getData());

    // Assignment 5: Heap Task-2
    System.out.println("Task-2");
    BSTToHeapTransformer bstToHeapTransformer = new BSTToHeapTransformer();
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);

    List<Node> bstToMinHeapNodes = bstToHeapTransformer.bstToMinHeap(root);
    System.out.println("BST To Min Heap: ");
    for (Node node : bstToMinHeapNodes) {
      System.out.print(node.getData() + " ");
    }
    System.out.println();

    Node bstToMaxHeapNode = new Node(4);
    bstToMaxHeapNode.left = new Node(2);
    bstToMaxHeapNode.right = new Node(6);
    bstToMaxHeapNode.left.left = new Node(1);
    bstToMaxHeapNode.left.right = new Node(3);
    bstToMaxHeapNode.right.left = new Node(5);
    bstToMaxHeapNode.right.right = new Node(7);

    List<Node> bstToMaxHeapNodes = bstToHeapTransformer.bstToMaxHeap(bstToMaxHeapNode);
    System.out.println("BST To Max Heap: ");
    for (Node node : bstToMaxHeapNodes) {
      System.out.print(node.getData() + " ");
    }
  }
}