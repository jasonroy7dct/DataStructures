package assignment2;

import java.util.ArrayList;

/**
 * Task-3: Implement a Queue data structure from scratch. You cannot use built-in Queue APIs. You
 * can use the built-in Array or List or your custom-built LinkedList.  The Queue class must have
 * the following functions. Write sample test cases to validate your implementation.
 *
 * @param <E>
 */
// Generics for putting different object
public class Queue<E> {

  int front = -1;
  int back = -1;

  private final ArrayList<E> elements;

  public Queue() {
    elements = new ArrayList<>();
  }

  /**
   * enqueue element at the back in the queue.
   * Time complexity is O(1) in average case, it is O(n) in worst case
   */
  public void enqueue(E element) {
    if (isEmpty()) {
      front = 0;
      back = 0;
    } else {
      back++;
    }
    elements.add(element);
  }

  /**
   * remove and return the earliest element from the queue.
   * Time complexity is O(1) in best case, it is O(n) in worst case
   */
  public E dequeue() {
    if (this.isEmpty()) {
      return null;
    } else {
      E removedElement = elements.get(front);
      elements.remove(front);
      if (isEmpty()) {
        front = -1;
        back = -1;
      }
      return removedElement;
    }
  }

  /**
   * returns the earliest element without removing it.
   * Time complexity is O(1)
   * @return E
   */
  public E poll() {
    if (front == -1) {
      return null;
    } else {
      return elements.get(front);
    }
  }

  /**
   * returns the size of the queue.
   *
   * @return int
   */
  public int size() {
    return elements.size();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }
}
