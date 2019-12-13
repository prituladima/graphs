package com.prituladima.graphs.util;

import com.prituladima.graphs.Request;
import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.prituladima.graphs.TestsReader.readExpectedResult;
import static com.prituladima.graphs.TestsReader.readRequests;

public class DJUSParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    private static final String BASE = System.getProperty("user.dir");
    private static final int AMOUNT_OF_TESTS = 1;
    private static DJUSParametrizedArgumentSupplier supplier;

    public static DJUSParametrizedArgumentSupplier supplier() {
        if (supplier == null) {
            supplier = new DJUSParametrizedArgumentSupplier();
        }
        return supplier;
    }

    private DJUSParametrizedArgumentSupplier() {
    }

    @Override
    public Stream<Arguments> get() {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner inScanner = new Scanner(new File(BASE + "/src/test/djus/input.djus.txt"));
             Scanner outScanner = new Scanner(new File(BASE + "/src/test/djus/output.djus.txt"))) {
            for (int i = 0; i < AMOUNT_OF_TESTS; i++) {

                int amountOfVertexes = inScanner.nextInt();


                List<Request> requests = new ArrayList<>();
                readRequests(requests, inScanner);

                List<Integer> expectedResult = new ArrayList<>();
                readExpectedResult(expectedResult, outScanner);

                ans.add(Arguments.of(amountOfVertexes, requests, expectedResult));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return ans.stream();
    }

}