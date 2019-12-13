package com.prituladima.graphs;

import java.util.Collection;

public class CyclicDependencyException extends IllegalArgumentException{

    public CyclicDependencyException(Collection<Integer> stack) {
        super(stack.toString());
    }

}
