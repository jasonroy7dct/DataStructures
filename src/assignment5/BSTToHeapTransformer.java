package assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Task-2: Write a class BSTToHeapTransformer that takes the root node of a BST and converts it into
 * a Min-Heap and Max-Heap. To write this BSTToHeapTransformer class, You must utilize your
 * implemented BST class. Write sample test cases to validate your implementation.
 */
public class BSTToHeapTransformer {

  static int index;

  /**
   * Takes the root node of a BST and converts it into a Min-Heap
   * <p>
   * Time complexity is O(n)
   * <p>
   * Space complexity is O(n) in the worst case, O(log n) in the balanced tree
   *
   * @param bst The root node of the BST to be converted into a Min-Heap.
   * @return List<Node> Min heap
   */
  public static List<Node> bstToMinHeap(Node bst) {
    index = 0;
    // initial the arrayList
    ArrayList<Integer> arrayList = new ArrayList<>();
    // put bst to arrayList
    bstToArrayList(bst, arrayList);
    // put arrayList to minHeap
    arrayListToMinHeap(bst, arrayList);
    // initial the minHeapList
    List<Node> minHeapList = new ArrayList<>();
    // add the arrayList to the minHeapList
    for (Integer value : arrayList) {
      minHeapList.add(new Node(value));
    }
    return minHeapList;
  }

  private static void arrayListToMinHeap(Node root, ArrayList<Integer> arrayList) {
    if (root != null) {
      root.data = arrayList.get(index);
      arrayListToMinHeap(root.left, arrayList);
      arrayListToMinHeap(root.right, arrayList);
    }
  }

  /**
   * Takes the root node of a BST and converts it into a Max-Heap
   * <p>
   * Time complexity is O(n * log(n))
   * <p>
   * Space complexity is O(n) in the worst case, O(log n) in the balanced tree
   *
   * @param bst The root node of the BST to be converted into a Max-Heap.
   * @return List<Node> Max heap
   */
  public static List<Node> bstToMaxHeap(Node bst) {
    index = 0;
    // initial the arrayList
    ArrayList<Integer> arrayList = new ArrayList<>();
    // put bst to arrayList
    bstToArrayList(bst, arrayList);
    // sort the array in descending order
    Collections.sort(arrayList, Collections.reverseOrder());
    // initial the maxHeapList
    List<Node> maxHeapList = new ArrayList<>();
    // add the arrayList to the maxHeapList
    for (Integer value : arrayList) {
      maxHeapList.add(new Node(value));
    }
    return maxHeapList;
  }

  // in-order traversal, to retrieve the elements of a bst in ascending order
  private static void bstToArrayList(Node root, ArrayList<Integer> arrayList) {
    if (root != null) {
      bstToArrayList(root.left, arrayList);
      arrayList.add(root.data);
      bstToArrayList(root.right, arrayList);
    }
  }
}
