package com.prituladima.graphs.algos;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// TODO: 13.12.2019 Make dfs 
// TODO: 13.12.2019 Make dfs with logs
public class DFSImpl {

    private static final int inf = (int) 1e6;

    private boolean[] used = new boolean[inf];

    public void dfs(int from, Map<Integer, Collection<Integer>> graph, List<Integer> ans, int deep){
        used[from] = true;
        ans.add(from);

        printTab(deep, String.format("%d", from));

        for (int to : graph.get(from)) {
            if (!used[to]) {
                dfs(to, graph, ans, deep + 1);
            }
        }
    }

    private void printTab(int deep, String message){
        char[] chars = new char[deep];
        Arrays.fill(chars, '\t');
        System.out.println(String.valueOf(chars) + message);
    }


}