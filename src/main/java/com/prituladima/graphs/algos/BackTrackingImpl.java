package com.prituladima.graphs.algos;

import java.util.Collection;
import java.util.Map;

// TODO: 13.12.2019 Find any path from - to
public class BackTrackingImpl {


    boolean[] used = new boolean[(int)1e6];

    int count = 0;

    public int go(int from, int dest, Map<Integer, Collection<Integer>> graph) {

        used[from] = true;

        if(from  == dest){
            count++;

        }else {

            for(int to : graph.get(from)){
                if (!used[to]) {
                    go(to, dest, graph);
                }
            }

        }

        used[from] = false;




        return count;
    }

}
