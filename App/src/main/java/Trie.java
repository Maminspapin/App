import java.util.HashMap;
import java.util.Set;

public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word, int index) {
            HashMap<Character, TrieNode> children = root.getChildren();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node;
                if (children.containsKey(ch)) {
                    node = children.get(ch);
                } else {
                    node = new TrieNode(ch);
                    children.put(ch, node);
                }
                children = node.getChildren();

                if (i == word.length() - 1) {
                    node.setLeaf(true);
                    node.getIndexes().add(index);
                }
            }
        }

        public Set<Integer> search(String word) {
            HashMap<Character, TrieNode> children = root.getChildren();

            TrieNode node = null;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (children.containsKey(ch)) {
                    node = children.get(ch);
                    children = node.getChildren();
                } else {
                    node = null;
                    break;
                }
            }

            if (node != null && node.isLeaf()) {
                return node.getIndexes();
            } else {
                return null;
            }
        }

    }



