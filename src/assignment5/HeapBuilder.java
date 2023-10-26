package assignment5;

import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//The best-case time complexity of heap sort is:
//
//O(n log n)

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
public class HeapBuilder {

  /**
   * Task-1: Given a list of integers, write a class HeapBuilder that takes the integer list,
   * creates a heap, and returns that heap as a binary tree. You have to implement both Max-Heap and
   * Min-Heap. Write sample test cases to validate your implementation.
   *
   * @return Node
   */
  // return the root of the binary tree (min value)
  public Node createMinHeap(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }
    Queue<Node> minHeap = new PriorityQueue<>();
    for (Integer value : values) {
      Node node = new Node(value);
      minHeap.add(node);
    }
    return minHeap.poll();
  }

  public Node createMaxHeap(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }
    Queue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (Integer value : values) {
      Node node = new Node(value);
      maxHeap.add(node);
    }
    return maxHeap.poll();
  }
}
