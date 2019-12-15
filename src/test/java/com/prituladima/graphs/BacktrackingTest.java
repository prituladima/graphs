package com.prituladima.graphs;

import com.prituladima.graphs.algos.BackTrackingImpl;
import com.prituladima.graphs.algos.TopSortImpl;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.BACKTRACKING;
import static com.prituladima.graphs.util.ParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BacktrackingTest {

    public static Stream<Arguments> ARGUMENTS = supplier(BACKTRACKING).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_backtracking(String name, Map<Integer, Collection<Integer>> graph, int form, int to, int expectedAns) {

        //GIVEN
        BackTrackingImpl backTracking = new BackTrackingImpl();

        //WHEN
        int actualAns = backTracking.go(form, to, graph);

        System.out.printf("From %d dest %d - > %d\n", form, to, actualAns);
        //THEN
        assertEquals(expectedAns, actualAns);


    }



}
