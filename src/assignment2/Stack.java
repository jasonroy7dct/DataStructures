package assignment2;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Task-1: Implement a stack data structure from scratch. You can’t use built-in Stack APIs. You can
 * use the built-in Array or List or your custom-built LinkedList.  The Stack class must have the
 * following functions. Write sample test cases to validate your implementation.
 *
 * @param <E>
 */
// Generics for putting different object
public class Stack<E> {

  private final ArrayList<E> elements;
  // initial capacity of the Stack when it constructs
  private final int capacity;
  // initial the default size
  private static final int DEFAULT_SIZE = 100;

  // constructor of Stack
  public Stack(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must large than 0");
    }
    this.capacity = capacity;
    elements = new ArrayList<>();
  }

  public Stack() {
    this.capacity = DEFAULT_SIZE;
    this.elements = new ArrayList<>();
  }


  /**
   * pushes element in the stack.
   * Time complexity is O(1)
   */
  public void push(E element) {
    // validate whether the stack is full
    if (isFull()) {
      throw new IllegalStateException("This Stack is already full");
    }
    elements.add(element);
  }

  /**
   * removes the latest element from the stack and returns it.
   * Time complexity is O(1) in average case, O(n) in worst case
   * @return E
   */
  public E pop() {
    // validate the stack is empty
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return elements.remove(elements.size() - 1);
  }

  /**
   * returns the latest element from the stack without removing it
   *
   * @return E
   */
  public E peek() {
    // validate the stack is empty
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return elements.get(elements.size() - 1);
  }

  /**
   * returns the size of the stack.
   *
   * @return int
   */
  public int size() {
    return elements.size();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }

  public boolean isFull() {
    return elements.size() == capacity;
  }
}
