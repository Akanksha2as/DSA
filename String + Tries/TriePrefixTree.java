//https://leetcode.com/problems/implement-trie-prefix-tree/submissions/1716887894/?envType=problem-list-v2&envId=trie
public class TriePrefixTree {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public TriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String s) {
        TrieNode curr = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }

    public static void main(String[] args) {
        TriePrefixTree trie = new TriePrefixTree();

        trie.insert("apple");
        System.out.println(trie.search("apple"));     
        System.out.println(trie.search("app"));       
        System.out.println(trie.startsWith("app"));   

        trie.insert("app");
        System.out.println(trie.search("app"));       
    }
}
