package assignment3;

import java.util.LinkedList;

public class HashTable {

  public static class HashNode {

    String key;
    String value;

    public HashNode(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedList<HashNode>[] hashTable;
  private int capacity;
  private int size;

  /**
   * HashTable: A fixed-size array or list. Depending on your hash function, this array or list can
   * be one-dimensional or two-dimensional.
   *
   * @param capacity the number of buckets or slots available in the hash table
   */
  public HashTable(int capacity) {
    this.hashTable = new LinkedList[capacity];
    this.capacity = capacity;
    for (int i = 0; i < capacity; i++) {
      hashTable[i] = new LinkedList<>();
    }
    this.size = 0;
  }

  /**
   * hash(x): A hash function that converts a string x to an integer, i.e., index in the hashtable.
   * You can implement any hash function described in the textbook. Your hash function must have a
   * collision-resolution mechanism. Time complexity is O(1)
   */
  private int hash(String key) {
    int hashValue = key.hashCode();
    return Math.abs(hashValue % capacity);
  }

  /**
   * insert(x):  Insert string x to the HashTable in the index returned by hash(x).
   * <p>
   * Time complexity is O(1), worst case is O(n), space complexity is O(n)
   * <p>
   * use separate chaining to solve the collision issue
   * <p>
   * Advantages: Simple to implement. Efficient for a wide range of load factors. Disadvantages: Can
   * result in inefficient memory usage, especially when the load factor is low. Slower lookup times
   * for high load factors or when collisions are frequent.
   *
   * @param key   key of the value
   * @param value data
   */

  public void insert(String key, String value) {
    int index = hash(key);
    LinkedList<HashNode> hashNodeLinkedList = hashTable[index];
    for (HashNode hashNode : hashNodeLinkedList) {
      if (hashNode.key.equals(key)) {
        hashNode.value = value;
        // key already exists, update the value and return
        return;
      }
    }
    // key doesn't exist, add a new key value
    hashNodeLinkedList.add(new HashNode(key, value));
    size++;
  }

  /**
   * insert(x):  Insert string x to the HashTable in the index returned by hash(x). Time complexity
   * is O(1), worst case is O(n), space complexity is O(n)
   *
   * @param key to find value
   * @return string
   */
  public String get(String key) {
    int index = hash(key);
    LinkedList<HashNode> hashNodeLinkedList = hashTable[index];
    for (HashNode hashNode : hashNodeLinkedList) {
      if (hashNode.key.equals(key)) {
        return hashNode.value;
      }
    }
    return null;
  }

  /**
   * remove(x): Delete string x of the HashTable in the index and returned the removed x
   *
   * @param key to find value
   * @return removed value
   */
  public String remove(String key) {
    int index = hash(key);
    LinkedList<HashNode> hashNodeLinkedList = hashTable[index];
    for (HashNode hashNode : hashNodeLinkedList) {
      if (hashNode.key.equals(key)) {
        String removedValue = hashNode.value;
        hashNodeLinkedList.remove(hashNode);
        return removedValue;
      }
    }
    return null;
  }

  /**
   * size():  Returns the size of the elements, i.e., the number of keys.
   *
   * @return int size
   */
  public int size() {
    return size;
  }
}
