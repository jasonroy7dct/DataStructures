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
   * pushes x in the stack.
   */
  public void push(E element) {
    queueOne.enqueue(element);
    topElement = element;
  }

  /**
   * removes the latest element from the stack and returns it.
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
    //The swap operation is used to make queueTwo the new queueOne and vice versa, so the data structure is ready for subsequent push and pop operations.
    //
    //So, the swap effectively switches the roles of queueOne and queueTwo, ensuring that the stack always pops the last element added. This way, the two queues work together to maintain the LIFO behavior of a stack.

    E poppedElement = queueOne.dequeue();
    Queue<E> temp = queueOne;
    queueOne = queueTwo;
    queueTwo = temp;
    return poppedElement;
  }

  /**
   * returns the latest element from the stack without removing it
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
