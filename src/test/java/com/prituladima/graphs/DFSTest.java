package com.prituladima.graphs;

import com.prituladima.graphs.algos.DFSImpl;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSTest {

    public static Stream<Arguments> ARGUMENTS = supplier(DFS).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_dfs_order(String name, Map<Integer, Collection<Integer>> graph, int from, List<Integer> expectedAns) {

        //GIVEN
        DFSImpl dfsImpl = new DFSImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        dfsImpl.dfs(from, graph, actualAns);

        //THEN
        assertEquals(expectedAns, actualAns);

    }


}
