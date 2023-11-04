package assignment5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Task Description
 * <p>
 * A heap is a binary tree where each node can have at most two children – the left child and the
 * right child. For a min-heap, the value of each node must be less than or equal to the values of
 * its children (i.e., the minimum value is at the root). For a max-heap, the value of each node
 * must be greater than or equal to the values of its children (i.e., the maximum value is at the
 * root). Due to the heap order property, the root of the heap is always the minimum (in a min-heap)
 * or maximum (in a max-heap) element, making it easy to access the most significant element without
 * having to search through the entire data structure.
 */
public class HeapBuilderWithHeapify {

  /**
   * Task-1: Given a list of integers, write a class HeapBuilder that takes the integer list,
   * creates a heap, and returns that heap as a binary tree. You have to implement both Max-Heap and
   * Min-Heap. Write sample test cases to validate your implementation.
   *
   * @return Node
   */
  // return the root of the binary tree (min value)
  // Time complexity is O(n * log(n))
  // Space complexity is O(n), and O(log n) in balanced cases.
  // create a Min-Heap from a list of values
  public Node createMinHeap(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
    minHeap.poll();

    int n = values.size();

    // build the Min-Heap using heapify min
    // start from the first index of non-leaf node whose index is given by n/2 - 1
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyMin(values, n, i);
    }

    // create the root node of the binary tree
    Node root = new Node(values.get(0));

    // build the binary tree structure from the Min-Heap
    buildTree(values, root, 0);

    return root;
  }

  // return the root of the binary tree (maz value)
  // Time complexity is O(n * log(n))
  // Space complexity is O(n), and O(log n) in balanced cases.
  // create a Max-Heap from a list of values
  public Node createMaxHeap(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }

    int n = values.size();

    // build the Max-Heap using heapify max
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyMax(values, n, i);
    }

    // create the root node of the binary tree
    Node root = new Node(values.get(0));

    // build the binary tree structure from the Max-Heap
    buildTree(values, root, 0);

    return root;
  }

  // Perform Min-Heapify operation on an element at index i
  private void heapifyMin(List<Integer> values, int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    // find the index of the smallest child
    if (left < n && values.get(left) < values.get(smallest)) {
      smallest = left;
    }
    if (right < n && values.get(right) < values.get(smallest)) {
      smallest = right;
    }

    // if the smallest element is not the current element, swap them and continue heapifying
    if (smallest != i) {
      swap(values, i, smallest);
      heapifyMin(values, n, smallest);
    }
  }

  // perform Max-Heapify operation on an element at index i
  private void heapifyMax(List<Integer> values, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    // find the index of the largest child
    if (left < n && values.get(left) > values.get(largest)) {
      largest = left;
    }
    if (right < n && values.get(right) > values.get(largest)) {
      largest = right;
    }

    // if the largest element is not the current element, swap them and continue heapifying
    if (largest != i) {
      swap(values, i, largest);
      heapifyMax(values, n, largest);
    }
  }

  // swap two elements(current and smallest/largest) in the list
  private void swap(List<Integer> values, int i, int j) {
    int temp = values.get(i);
    values.set(i, values.get(j));
    values.set(j, temp);
  }

  // build the binary tree structure from the heap-ordered array, use recursion
  private void buildTree(List<Integer> values, Node node, int index) {
    int leftIndex = 2 * index + 1;
    int rightIndex = 2 * index + 2;

    // create left child and recursively build its subtree
    if (leftIndex < values.size()) {
      node.left = new Node(values.get(leftIndex));
      buildTree(values, node.left, leftIndex);
    }

    // create right child and recursively build its subtree
    if (rightIndex < values.size()) {
      node.right = new Node(values.get(rightIndex));
      buildTree(values, node.right, rightIndex);
    }
  }
}
