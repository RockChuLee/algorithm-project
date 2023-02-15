package com.nyu.datastructure.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    private static int COLS;
    private static int ROWS;
    private Node currentTrie;

    Node root = new Node('\0');

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        HashSet<String> res = new HashSet<>();
        HashSet<String> visit = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, root, "", res, visit, board, root);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, Node node, String word, HashSet<String> res, HashSet<String> visit, char[][] board, Node root
    ) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS ||
                node.children[board[r][c] - 'a'] == null ||
                node.children[board[r][c] - 'a'].refs < 1 ||
                visit.contains(r + "-" + c)
        ) {
            return;
        }

        visit.add(r + "-" + c);
        node = node.children[board[r][c] - 'a'];
        word += board[r][c];
        if (node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        dfs(r + 1, c, node, word, res, visit, board, root);
        dfs(r - 1, c, node, word, res, visit, board, root);
        dfs(r, c + 1, node, word, res, visit, board, root);
        dfs(r, c - 1, node, word, res, visit, board, root);
        visit.remove(r + "-" + c);
    }

    class Node {

        public char value;
        public boolean isWord;
        public Node[] children;
        public int refs;

        public Node(char val) {
            this.value = val;
            this.isWord = false;
            this.children = new Node[26];
            this.refs = 0;
        }

        public void addWord(String word) {
            Node curr = root;
            curr.refs += 1;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (curr.children[currentCharacter - 'a'] == null) {
                    curr.children[currentCharacter - 'a'] = new Node(currentCharacter);
                }
                curr = curr.children[currentCharacter - 'a'];
                curr.refs += 1;
            }
            curr.isWord = true;
        }

        public void removeWord(String word) {
            Node curr = this;
            curr.refs -= 1;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (curr.children[currentCharacter - 'a'] != null) {
                    curr = curr.children[currentCharacter - 'a'];
                    curr.refs -= 1;
                }
            }
        }
    }
}
