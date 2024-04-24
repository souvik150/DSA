package Graphs;

import java.util.*;

public class WordLadder2 {

  // Method to find all shortest paths from beginWord to endWord
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<List<String>>> map = new HashMap<>();
    Map<String, Integer> steps = new HashMap<>();
    int minStep = Integer.MAX_VALUE;

    // Initial step counts for beginWord is 1
    steps.put(beginWord, 1);

    // Queue for BFS
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);

    // Initialize paths for beginWord
    map.put(beginWord, new ArrayList<>());
    map.get(beginWord).add(new ArrayList<>(Arrays.asList(beginWord)));

    // BFS
    while (!q.isEmpty()) {
      String word = q.poll();
      int currStep = steps.get(word);

      // If current step is greater than minimum step found so far, break
      if (currStep >= minStep)
        break;

      for (int i = 0; i < word.length(); i++) {
        char[] chars = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
          chars[i] = ch;
          String newWord = new String(chars);
          if (dict.contains(newWord)) {
            if (newWord.equals(endWord)) {
              minStep = currStep;
              for (List<String> l : map.get(word))
                ans.add(new ArrayList<>(l) {
                  {
                    add(endWord);
                  }
                });
            }

            // If it's the first time we reach this word
            if (!steps.containsKey(newWord) || steps.get(newWord) == currStep + 1) {
              if (!map.containsKey(newWord)) {
                q.add(newWord);
                map.put(newWord, new ArrayList<>());
                steps.put(newWord, currStep + 1);
              }
              for (List<String> l : map.get(word))
                map.get(newWord).add(new ArrayList<>(l) {
                  {
                    add(newWord);
                  }
                });
            }
          }
        }
      }
    }
    return ans;
  }

  // Main function to execute the code
  public static void main(String[] args) {
    WordLadder2 wl = new WordLadder2();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    List<List<String>> result = wl.findLadders(beginWord, endWord, wordList);
    for (List<String> path : result) {
      System.out.println(path);
    }
  }
}
