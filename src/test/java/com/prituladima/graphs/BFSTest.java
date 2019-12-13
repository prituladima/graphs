package com.prituladima.graphs;

import com.prituladima.graphs.algos.BFSImpl;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.BFS;
import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {

    public static Stream<Arguments> ARGUMENTS = supplier(BFS).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_bfs_order(String name, Map<Integer, Collection<Integer>> graph, int from, List<Integer> expectedAns) {

        //GIVEN
        BFSImpl bfsImpl = new BFSImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        bfsImpl.bfs(from, graph, actualAns);

        //THEN
        assertEquals(expectedAns, actualAns);

    }

}