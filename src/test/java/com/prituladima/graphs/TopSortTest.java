package com.prituladima.graphs;

import com.prituladima.graphs.algos.DFSImpl;
import com.prituladima.graphs.algos.TopSortImpl;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.DFS;
import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopSortTest {

    public static Stream<Arguments> ARGUMENTS = supplier(DFS).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_top_sort_order(String name, Map<Integer, Collection<Integer>> graph, int from, List<Integer> expectedAns) {

        //GIVEN
        TopSortImpl topSort = new TopSortImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        topSort.topSort(graph, actualAns);

        //THEN
        assertEquals(expectedAns, actualAns);

    }

}
