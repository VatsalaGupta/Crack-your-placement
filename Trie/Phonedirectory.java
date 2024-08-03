package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Phonedirectory {
    public static void main(String[] args) {
        int n = 3;
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        ArrayList<ArrayList<String>> result = displayContacts(n, contact, s);
        for (ArrayList<String> list : result) {
            System.out.println(list);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        ArrayList<String> words;

        TrieNode() {
            children = new HashMap<>();
            words = new ArrayList<>();
        }
    }

    static TrieNode buildTrie(String[] contacts) {
        TrieNode root = new TrieNode();
        for (String contact : contacts) {
            TrieNode node = root;
            for (char ch : contact.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
                node.words.add(contact);
            }
        }
        return root;
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        TrieNode root = buildTrie(contact);

        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (node == null || !node.children.containsKey(ch)) {
                // result.add(Collections.singletonList("0"));
                node = null;
            } else {
                node = node.children.get(ch);
                ArrayList<String> words = new ArrayList<>(node.words);
                Collections.sort(words);
                result.add(words);
            }
        }

        return result;
    }
}
