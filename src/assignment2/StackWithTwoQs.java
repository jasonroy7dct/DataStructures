package assignment2;

import java.util.ArrayList;
import java.util.Comparator;

public class StackWithTwoQs<E> {

  private final ArrayList<E> elements = new ArrayList<>();

  Queue<E> queueOne = new Queue<>(elements);

  Queue<E> queueTwo = new Queue<>(elements);

  // all stack methods

  /**
   * pushes x in the stack.
   */
  public void push(E element) {
    queueOne.enqueue(element);
  }

  /**
   * removes the latest element from the stack and returns it.
   */
  public E pop() {
    if (queueOne.isEmpty()) {
      while (queueTwo.size() > 1) {
        queueTwo.enqueue(queueOne.dequeue());
      }
      E poppedElement = queueOne.dequeue();
      Queue<E> temp = queueOne;
      queueOne = queueTwo;
      queueTwo = temp;
      return poppedElement;
    } else {
      return queueOne.dequeue();
    }
  }

  /**
   * returns the latest element from the stack without removing it
   */
  public E peek() {
    if (queueOne.isEmpty()) {
      while (queueTwo.size() > 1) {
        queueTwo.enqueue(queueOne.dequeue());
      }
      E polledElement = queueOne.poll();
      Queue<E> temp = queueOne;
      queueOne = queueTwo;
      queueTwo = temp;
      return polledElement;
    } else {
      // call poll to returns the earliest element without removing it
      return queueOne.poll();
    }
  }

  /**
   * returns the size of the stack.
   */
  public int size() {
    return queueOne.size();
  }
}
