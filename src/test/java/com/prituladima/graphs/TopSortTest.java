package com.prituladima.graphs;

import com.prituladima.graphs.algos.TopSortImpl;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.TOP_SORT;
import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TopSortTest {

    public static Stream<Arguments> ARGUMENTS = supplier(TOP_SORT).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_top_sort_order(String name, Map<Integer, Collection<Integer>> graph, List<Integer> expectedAns) {

        //GIVEN
        TopSortImpl topSort = new TopSortImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        if (!expectedAns.isEmpty()) {
            topSort.topSort(graph, actualAns);
            assertEquals(expectedAns, actualAns);
        } else assertThrows(CyclicDependencyException.class, () -> {
            topSort.topSort(graph, actualAns);
        });


    }

}
