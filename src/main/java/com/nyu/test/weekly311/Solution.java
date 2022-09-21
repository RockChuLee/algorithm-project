package com.nyu.test.weekly311;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {

    public int[] sumPrefixScores(String[] words) {
        int length = words.length;
        int[] ans = new int[length];
        for (String word : words) {
            insert(word);
        }
        int index = 0;
        for (String word : words) {
            int sum = 0;
            for (int i = 1; i < word.length(); i++) {
                sum += search(word.substring(0, i));
            }
            ans[index] = sum;
            index++;
        }

        return ans;
    }

    Node root;

    public Solution() {
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
        curr.num ++;
    }

    public Integer search(String word) {
        Node res = getLast(word);
        if (res != null && res.isWord){
            return res.num;
        }else {
            return 0;
        }
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
        if (res == null) return false;
        return true;
    }

    class Node {

        private char value;
        private boolean isWord;
        private int num;
        private Node[] children;

        public Node(char val) {
            this.value = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    public static void main(String[] args) {
    }
}
