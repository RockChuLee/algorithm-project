package com.nyu.datastructure.tries;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class DesignAddandSearchWordsDataStructure {

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        WordDictionary obj = new WordDictionary();
        obj.addWord(word);
        boolean param_2 = obj.search(word);
    }

     static class WordDictionary {

        Node root;

        public WordDictionary() {
            root = new Node('\0');
        }

        public void addWord(String word) {
            Node curr = root;
            for(char c:word.toCharArray()){
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new Node(c);
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return searchHelper(word, root, 0);
        }

        private boolean searchHelper(String word, Node curr, int index) {
            for (int i = index; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ch == '.') {
                    for (Node temp : curr.children) {
                        if (temp != null && searchHelper(word, temp, i + 1)) {
                            return true;
                        }
                    }
                    return false;
                }

                if (curr.children[ch - 'a'] == null) {
                    return false;
                }

                curr = curr.children[ch - 'a'];
            }

            return curr.isWord;
        }

        static class Node{
            char val;
            boolean isWord;
            Node[] children;

            public Node(char val){
                this.val = val;
                this.isWord = false;
                this.children = new Node[26];
            }
        }
    }
}
