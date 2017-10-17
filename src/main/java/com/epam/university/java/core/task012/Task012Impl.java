package com.epam.university.java.core.task012;

import com.epam.university.java.core.utils.common.Validator;

import java.util.*;

/**
 * Class implements <code>Task012</code> interface.
 */
public class Task012Impl implements Task012 {
    public boolean stopCycling = false;

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction>
            actions) {
        Validator.validateNotNull(sourceGraph, actions,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        for (GraphAction graphAction : actions) {
            graphAction.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Validator.validateNotNull(graph, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateValueRange(from, 1, 1000,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateValueRange(to, 1, 1000,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Map<Integer, Set<Integer>> graphMap = new HashMap<>
                (((GraphImpl) graph).getMapOfVertices());
        if (!graphMap.containsKey(from)) {
            return false;
        } else {
            return subFinder(new GraphImpl(graphMap, graphMap.size()), from, to);
        }
    }

    /**
     * Recursion for searching the path to <code>to</code>.
     *
     * @param graph graph with vertices
     * @param from  vertex path starts from
     * @param to    vertex path ends with
     * @return boolean if path exists
     */
    public boolean subFinder(Graph graph, int from, int to) {
        Map<Integer, Set<Integer>> graphMap = ((GraphImpl) graph)
                .getMapOfVertices();
        if (!graphMap.containsKey(from)) {
            return false;
        }
        List<Integer> tempList = new ArrayList<>(graphMap.get(from));
        if (graphMap.get(from).contains(to)) {
            stopCycling = true;
            return true;
        }
        graphMap.remove(from);
        tempList.remove(new Integer(from));
        for (int i = 0; i < tempList.size(); i++) {
            graph.removeEdge(tempList.get(i), from);
            subFinder(graph, tempList.get(i), to);
            if (stopCycling) {
                return true;
            }
        }
        return false;
    }
}