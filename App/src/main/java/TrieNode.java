import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class TrieNode {
    private Character ch;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private Set<Integer> indexes;
    private boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char ch) {
        this.ch = ch;
        this.indexes = new TreeSet<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Set<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(Set<Integer> indexes) {
        this.indexes = indexes;
    }
}

