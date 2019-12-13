package com.prituladima.graphs;

import java.util.*;

public class TestsReader {

    public static void readGraph(Map<Integer, Collection<Integer>> graph, Scanner scanner) {
        // TODO: 13.12.2019 Change this ugly Map to Graph
        int amountOfVertexes = scanner.nextInt();
        for (int from = 0; from < amountOfVertexes; from++) {
            graph.put(from, new LinkedHashSet<>());
        }
        int amountOfEdges = scanner.nextInt();
        boolean isDirected = scanner.nextBoolean();

        for (int i = 0; i < amountOfEdges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.get(from).add(to);
            if (!isDirected) {
                graph.get(to).add(from);
            }
        }
    }

    public static int readFromVertex(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void readExpectedResult(List<Integer> ans, Scanner scanner) {
        int n = scanner.nextInt();
        while (n-- > 0) ans.add(scanner.nextInt());
    }

    public static void readRequests(List<Request> requests, Scanner scanner) {
        int n = scanner.nextInt();
        while (n-- > 0) {
            String type = scanner.next();
            if (Objects.equals(type, "AMOUNT"))
                requests.add(new Request(type));
            else
                requests.add(new Request(type, scanner.nextInt(), scanner.nextInt()));

        }
    }
}
