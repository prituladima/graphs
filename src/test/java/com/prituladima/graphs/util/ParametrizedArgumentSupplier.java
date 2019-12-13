package com.prituladima.graphs.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.prituladima.graphs.TestsReader.*;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    public static final String BFS = "bfs";
    public static final String DFS = "dfs";
    public static final String TOP_SORT = "top";

    private static final String BASE = System.getProperty("user.dir");
//    private static final int AMOUNT_OF_TESTS = 9;
    private static Map<String, ParametrizedArgumentSupplier> suppliers;

    public static ParametrizedArgumentSupplier supplier(String type) {
        suppliers = new HashMap<>();
        suppliers.computeIfAbsent(BFS, key -> new ParametrizedArgumentSupplier(type));
        suppliers.computeIfAbsent(DFS, key -> new ParametrizedArgumentSupplier(type));
        suppliers.computeIfAbsent(TOP_SORT, key -> new ParametrizedArgumentSupplier(type));
        return suppliers.get(type);
    }

    private String type;

    private ParametrizedArgumentSupplier(String type) {
        this.type = type;
    }

    @Override
    public Stream<Arguments> get() {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner namesScanner = new Scanner(new File(BASE + "/src/test/names.txt"));
             Scanner inScanner = new Scanner(new File(BASE + "/src/test/input.txt"));
             Scanner outScanner = new Scanner(new File(BASE + "/src/test/output." + type + ".txt"))) {

            int amountOfTests = inScanner.nextInt();
            for (int i = 0; i < amountOfTests; i++) {
                String name = namesScanner.nextLine();
                Map<Integer, Collection<Integer>> graph = new HashMap<>();
                readGraph(graph, inScanner);
                int from = readFromVertex(inScanner);
                List<Integer> expectedResult = new ArrayList<>();
                readExpectedResult(expectedResult, outScanner);
                ans.add(Arguments.of(name, graph, from, expectedResult));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ans.stream();
    }
}
