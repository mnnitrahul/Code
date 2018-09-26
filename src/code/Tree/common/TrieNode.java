package code.Tree.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul.ka on 25/09/16.
 */
public class TrieNode {
    public char c;
    public Map<Character, TrieNode> nodes;
    public String value;
    public TrieNode(String value) {
        this.value = value;
        nodes = new HashMap<Character, TrieNode>();
    }
    public TrieNode() {
        nodes = new HashMap<Character, TrieNode>();
    }
}
