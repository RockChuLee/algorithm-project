package com.nyu.datastructure.graph;

public class Search {
    private boolean[] marked;
    private int count;

    public Search(Graph G, int s) {
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

}
