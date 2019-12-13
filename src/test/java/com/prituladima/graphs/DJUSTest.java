package com.prituladima.graphs;


import com.prituladima.graphs.datastructure.DisjointUnionSets;
import com.prituladima.graphs.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.prituladima.graphs.util.DJUSParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DJUSTest {

    public static Stream<Arguments> ARGUMENTS = supplier().get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    public void test_disjoint_union_sets(int amountOfVertexes, List<Request> requests, List<Integer> expectedResults) {
        DisjointUnionSets djus = new DisjointUnionSets(amountOfVertexes);

        int pointer = 0;
        for (Request request : requests) {
            if (Objects.equals(request.getType(), "AMOUNT")) {
                int expected = expectedResults.get(pointer++);
                int actual = djus.getAmount();
                assertEquals(expected, actual);
                System.out.printf("Amount of connected component expected: %d; actual: %d\n", expected, actual);

            } else if (Objects.equals(request.getType(), "JOIN")) {
                int from = request.getFrom();
                int to = request.getTo();
                djus.union(from, to);
                System.out.printf("Make union of: %d <> %d\n", from, to);

            } else if (Objects.equals(request.getType(), "CAN_GO?")) {
                int from = request.getFrom();
                int to = request.getTo();

                boolean expectedInTheSameSet = expectedResults.get(pointer++) == 1;
                boolean actualInTheSameSet = djus.isInSameSet(from, to);
                assertEquals(expectedInTheSameSet, actualInTheSameSet);

                System.out.printf("Vertexes are %sexpected to be in the same union: %d <> %d\n", expectedInTheSameSet ? "" : "not ", from, to);


            } else throw new IllegalStateException();
        }

    }

}
