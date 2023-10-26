package assignment3;

import java.util.LinkedList;

// x = string for the assignment
public class HashTable {

  //The expected runtime of data retrieval (e.g., getitem) from a well-implemented Hashtable is typically:
  //
  //O(1)
  // The worst-case runtime of data retrieval (e.g., getitem) from a Hashtable is typically:
  //
  //O(n)
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
   * collision-resolution mechanism.
   */
  private int hash(String key) {
    int hashValue = key.hashCode();
    return Math.abs(hashValue % capacity);
  }

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

  public int size() {
    return size;
  }
}
