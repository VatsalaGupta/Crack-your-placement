package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    private List<String> wordsList;

    public WordDictionary() {
        wordsList = new ArrayList<>();
    }
    
    public void addWord(String word) {
        wordsList.add(word);
    }
    
    public boolean search(String word) {
        for (String savedWord : wordsList) {
            if (savedWord.length() != word.length()) continue;

            boolean wordsMatch = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != '.' && savedWord.charAt(i) != word.charAt(i)) {
                    wordsMatch = false;
                    break;
                }
            }
            if (wordsMatch) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        
        System.out.println(dictionary.search("pad"));  // false
        System.out.println(dictionary.search("bad"));  // true
        System.out.println(dictionary.search(".ad"));  // true
        System.out.println(dictionary.search("b.."));  // true
    }
}
