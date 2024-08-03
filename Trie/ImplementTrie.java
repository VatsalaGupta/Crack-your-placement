package Trie;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // true
        System.out.println(trie.search("app"));    // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));    // true
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            root.insert(word, 0);
        }

        public boolean search(String word) {
            return root.search(word, 0);
        }

        public boolean startsWith(String prefix) {
            return root.startsWith(prefix, 0);
        }

        static class Node {
            Node[] nodes;
            boolean isEnd;

            Node() {
                nodes = new Node[26];
            }

            private void insert(String word, int idx) {
                if (idx >= word.length()) return;
                int i = word.charAt(idx) - 'a';
                if (nodes[i] == null) {
                    nodes[i] = new Node();
                }
                if (idx == word.length() - 1) nodes[i].isEnd = true;
                nodes[i].insert(word, idx + 1);
            }

            private boolean search(String word, int idx) {
                if (idx >= word.length()) return false;
                Node node = nodes[word.charAt(idx) - 'a'];
                if (node == null) return false;
                if (idx == word.length() - 1) return node.isEnd;
                return node.search(word, idx + 1);
            }

            private boolean startsWith(String prefix, int idx) {
                if (idx >= prefix.length()) return true;
                Node node = nodes[prefix.charAt(idx) - 'a'];
                if (node == null) return false;
                return node.startsWith(prefix, idx + 1);
            }
        }
    }
}
