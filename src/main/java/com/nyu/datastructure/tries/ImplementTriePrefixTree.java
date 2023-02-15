package com.nyu.datastructure.tries;

//https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node('\0'); //dummy node
        }

        public void insert(String word) {
            Node curr = root;
            for (char x : word.toCharArray()) {
                if (curr.children[x - 'a'] == null) {
                    curr.children[x - 'a'] = new Node(x);
                }
                curr = curr.children[x - 'a'];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            Node res = getLast(word);
            return (res != null && res.isWord);
        }

        //helper method
        public Node getLast(String word) {
            Node curr = root;
            for (char x : word.toCharArray()) {
                if (curr.children[x - 'a'] == null) {
                    return null;
                }
                curr = curr.children[x - 'a'];
            }
            return curr;
        }

        public boolean startsWith(String prefix) {
            Node res = getLast(prefix);
            return res != null;
        }

        static class Node {
            public char value;
            public boolean isWord;
            public Node[] children;

            public Node(char val) {
                this.value = val;
                this.isWord = false;
                this.children = new Node[26];
            }
        }
    }
}
