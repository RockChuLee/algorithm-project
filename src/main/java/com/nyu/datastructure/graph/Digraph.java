package com.nyu.datastructure.graph;

import com.nyu.util.Bag;
import com.nyu.util.In;

public class Digraph {
    private final int V;        //顶点数目
    private int E;              //边的数目
    private final Bag<Integer>[] adj; //邻接表

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];  //创建邻接表
        for (int v = 0; v < V; v++)          //将所有涟表初始化为空
            adj[v] = new Bag<Integer>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); //将w添加到v的链表中
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public String toString() {
        String s = V + " vertices，" + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;

    }
}
