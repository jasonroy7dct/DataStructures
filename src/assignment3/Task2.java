package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task2 {

  public int findTheNumberOfUniqueAnagramRoots(String fileName) throws IOException {

    HashTable hashTable = new HashTable(100000);
    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      // using any non-alphanumeric character as a delimiter
      String[] strArray = line.split("\\W+");
      for (String str : strArray) {
        String sortedString = sortCharacters(str);
        if (sortedString != null) {
          hashTable.insert(sortedString, str);
        }
      }
    }
    // the number of unique anagram roots
    return hashTable.size();
  }

  private String sortCharacters(String str) {
    if (str.isEmpty()) {
      return null;
    }
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
