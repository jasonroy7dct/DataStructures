package assignment2;

import java.util.ArrayList;

/**
 * Task-4: Implement a Stack using only two instances of your implemented Queue class (Task-3).
 * Write sample test cases to validate your implementation.
 *
 * @param <E>
 */
public class Task4StackWithTwoQs<E> {

  Queue<E> queueOne = new Queue<>();
  Queue<E> queueTwo = new Queue<>();
  private E topElement;

  // all stack methods

  /**
   * pushes x in the stack. Time complexity is O(1) in average case, it is O(n) in worst case Space
   * complexity is O(1)
   */
  public void push(E element) {
    queueOne.enqueue(element);
    topElement = element;
  }

  /**
   * removes the latest element from the stack and returns it. Time complexity is O(n), Space
   * complexity is O(1)
   */
  public E pop() {
    if (isEmpty()) {
      return null;
    }

    // move all elements except the last one from queueOne to queueTwo
    while (queueOne.size() > 1) {
      topElement = queueOne.dequeue();
      queueTwo.enqueue(topElement);
    }

    // dequeue the last element from queueOne (the top element of the stack)
    E poppedElement = queueOne.dequeue();

    // swap the roles of queueOne and queueTwo to make queueTwo the new queueOne for later push and pop operations
    Queue<E> temp = queueOne;
    queueOne = queueTwo;
    queueTwo = temp;
    // top clement
    return poppedElement;
  }

  /**
   * returns the latest element from the stack without removing it Time complexity is O(1), Space
   * complexity is O(1)
   */
  public E peek() {
    return topElement;
  }

  /**
   * returns the size of the stack.
   */
  public int size() {
    return queueOne.size();
  }

  public boolean isEmpty() {
    return queueOne.isEmpty();
  }
}
