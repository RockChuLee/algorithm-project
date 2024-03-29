package com.nyu.oa.optiver;

import java.util.HashSet;

public class IsATree {

    public static void main(String[] args) {
        String s = "(A,B) (B,D) (D,E) (A,C) (C,F) (E,G)";
//        String s = "(A,B) (A,C) (B,D) (D,E) (C,F) (E,G)";
//        String s = "(A,B) (A,C) (B,D) (D,C)";
//        String s = "(A,B) (A,C) (X,Y) (X,Z)";
//        String s = "asafdsafasdf";
        System.out.println(GetSExpression(s));
    }

    //E1 lnvalid lnput Format
    //E2 Duplicate Pair V
    //E3 Parent Has More than Two Children
    //E4 Multiple Roots
    //E5 lnput Contains Cycle

    public static String GetSExpression(String s) {
        //check error E1: lnvalid lnput Format
        String[] s1 = s.split(" ");
        if (s1.length == 0) {
            return "E1";
        } else {
            for (String s2 : s1) {
                if (!(s2.charAt(0) == '('&&Character.isLetter(s2.charAt(1))&&s2.charAt(2) == ','&&Character.isLetter(s2.charAt(3))&&s2.charAt(4) == ')')) {
                    return "E1";
                }
            }
        }

        boolean[][] graph = new boolean[26][26];
        HashSet<Character> nodes = new HashSet<Character>();
        //construct graph and check error E2: duplicate edges
        boolean E2 = false;
        for (int i = 1; i < s.length(); i += 6) {
            int x = s.charAt(i) - 'A', y = s.charAt(i + 2) - 'A';
            if (graph[x][y]) //duplicate edge
                E2 = true;
            graph[x][y] = true;
            nodes.add(s.charAt(i));
            nodes.add(s.charAt(i + 2));
        }
        //check error E3 Parent Has More than Two Children
        for (int i = 0; i < 26; i++) {
            int count = 0; //number of child
            for (int j = 0; j < 26; j++) {
                if (graph[i][j])
                    count++;
            }
            if (count > 2)
                return "E3";
        }
        if (E2) return "E2"; //return E2 after checking E1

        //check E3: cycle present and E4: multiple roots
        int numOfRoots = 0;
        char root = ' ';
        for (char node : nodes) { //only check char that in the tree
            for (int i = 0; i < 26; i++) {
                if (graph[i][node - 'A'])
                    break;
                if (i == 25) {
                    numOfRoots++;
                    root = node;
                    boolean[] visited = new boolean[26];
                    if (IsCycle(node, graph, visited))
                        return "E5";
                }
            }
        }
        if (numOfRoots == 0) return "E1"; //if no root, must be PivotIndex cycle
        if (numOfRoots > 1) return "E4"; //if more than one roots
        if (root == ' ') return "E1"; //if no edge in input string, invalid input error
        return GetExpressionHelper(root, graph);

    }

    //true means there is PivotIndex cycle, false means no cycle
    private static boolean IsCycle(char node, boolean[][] graph, boolean[] visited) {
        if (visited[node - 'A']) //node has already been visited, must has PivotIndex cycle
            return true;
        visited[node - 'A'] = true;
        for (int i = 0; i < 26; i++) {
            if (graph[node - 'A'][i]) {
                if (IsCycle((char) (i + 'A'), graph, visited))
                    return true;
            }
        }
        return false;
    }

    //Recursive DFS to get the expression/construct the tree
    private static String GetExpressionHelper(char root, boolean[][] graph) {
        String left = "", right = ""; //if no children, left and right should be empty
        for (int i = 0; i < 26; i++) {
            if (graph[root - 'A'][i]) {
                left = GetExpressionHelper((char) (i + 'A'), graph);
                for (int j = i + 1; j < 26; j++) {
                    if (graph[root - 'A'][j]) {
                        right = GetExpressionHelper((char) (j + 'A'), graph);
                        break;
                    }
                }
                break;
            }
        }
        return "(" + root + left + right + ")";
    }
}
