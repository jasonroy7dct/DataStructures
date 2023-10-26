package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Task-2: Read and parse each word from the file pride-and-prejudice.txt Download
 * pride-and-prejudice.txt. Note that this file is very large; therefore, reading the text at once
 * will crash your program. You should read the text line by line. To split a line into words, you
 * can consider anything other than alpha-numeric (i.e. [a-zA-Z0-9]) characters are delimiters, for
 * example, ‘\n’, ‘\t’, ‘,’, ‘.’ etc.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once. For example, `mango` and `gonma` are
 * anagrams containing the same characters. Write a function that would find out how many unique
 * anagram-root words are there in the novel. An anagram-root word is a word that is derived by
 * sorting the word by characters. For example, `mango`’s anagram root is `agmno`.
 * <p>
 * To find the number of unique anagram roots, do the following steps.
 * <p>
 * Step-1: While you parse each word from the file, sort the words by character. You can use any
 * built-in sorting API. Step-2: Insert the sorted words in the hashtable you implemented above. If
 * the word is already present in the hashtable, then skip it. Step-3: Once all the words have been
 * sorted and inserted (or skipped), call the size() function of the Hash class.
 */
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
