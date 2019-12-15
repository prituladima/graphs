package com.prituladima.graphs.algos;

import java.util.*;


// TODO: 13.12.2019 Implement bfs
// TODO: 13.12.2019 Implement bfs with time of burn
public class BFSImpl {

    private static final int inf = (int) 1e6;

    private boolean[] used = new boolean[inf];

    Map<Integer, Integer> vertexToTime = new HashMap<>();

    public void bfs(int from, Map<Integer, Collection<Integer>> graph, List<Integer> ans){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        ans.add(from);
        vertexToTime.put(from, 0);
        used[from] = true;

        while (!deque.isEmpty()) {
            int curVertex = deque.removeFirst();
            int timeCur = vertexToTime.get(curVertex);
            printTab(timeCur, curVertex);
            for (int to : graph.get(curVertex)) {
                if (!used[to]) {
                    used[to] = true;
                    deque.addLast(to);
                    ans.add(to);
                    vertexToTime.put(to, timeCur + 1);
                }
            }
        }
    }

    private void printTab(int level, int vertex){
        char[] chars = new char[level];
        Arrays.fill(chars, '\t');
        System.out.println(String.valueOf(chars) + vertex);
    }

}