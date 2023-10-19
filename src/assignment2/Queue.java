package assignment2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<E> {

  int front = -1;
  int rear = -1;

  private final ArrayList<E> elements;

  public Queue(ArrayList<E> elements) {
    this.elements = elements;
  }

  /**
   * enqueue element in the queue.
   */
  public void enqueue(E element) {
    if (isEmpty()) {
      front = 0;
      rear = 0;
      elements.add(element);
    } else {
      rear++;
      elements.set(rear, element);
    }
  }

  /**
   * remove and return the earliest element from the queue.
   */
  public E dequeue() {
    if (this.isEmpty()) {
      return null;
    } else {
      E removedElement = elements.get(front);
      elements.remove(front);
      if (isEmpty()) {
        front = -1;
        rear = -1;
      } else {
        front++;
      }
      return removedElement;
    }
  }

  /**
   * returns the earliest element without removing it.
   *
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
