package com.prituladima.graphs.algos;

import com.prituladima.graphs.CyclicDependencyException;

import java.util.*;

// TODO: 13.12.2019 Implement top sort
// TODO: 13.12.2019 if cyclic dependency is detected throw exception
// TODO: 13.12.2019 Exception must contains cycle
public class TopSortImpl {

    private static final int inf = (int) 1e6;

//    private int[] used = new int[inf];

    private State[] states = new State[inf];

    private Deque<Integer> cycleStack = new ArrayDeque<>();

    //Invariants
    enum State {
        NOT_VISITED,
        RESOLVING_STARTED,
        BEAN_READY_TO_USE
    }
    public void topSort(Map<Integer, Collection<Integer>> graph, List<Integer> ans) {

        Arrays.fill(states, State.NOT_VISITED);

        for (int vertex : graph.keySet()) {
            if (states[vertex] == State.NOT_VISITED) {
                topSort(vertex, graph, ans);
            }
        }

    }

    public void topSort(int from, Map<Integer, Collection<Integer>> graph, List<Integer> ans) {
        states[from] = State.RESOLVING_STARTED;

        cycleStack.addFirst(from);

        for (int to : graph.get(from)) {
            if (states[to] == State.NOT_VISITED) {
                topSort(to, graph, ans);
            } else if (states[to] == State.RESOLVING_STARTED) {
                while (cycleStack.getFirst() != to) {
                    cycleStack.removeFirst();
                }
                throw new CyclicDependencyException(cycleStack);
            } else if (states[to] == State.BEAN_READY_TO_USE) {
                //is okay
            }
        }

        cycleStack.removeFirst();

        states[from] = State.BEAN_READY_TO_USE;
        ans.add(from);
    }

}
