package Question5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b_ImpactedNetworkDevices {
    public static List<Integer> retrieveNodesWithSingleTargetAsParent(int[][] connections, int targetNode) {
        Map<Integer, List<Integer>> networkGraph = new HashMap<>();
        Map<Integer, Integer> incomingEdgesCount = new HashMap<>();

        for (int[] connection : connections) {
            int parent = connection[0];
            int child = connection[1];
            networkGraph.putIfAbsent(parent, new ArrayList<>());
            networkGraph.get(parent).add(child);
            incomingEdgesCount.put(child, incomingEdgesCount.getOrDefault(child, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        traverseNetwork(networkGraph, incomingEdgesCount, targetNode, targetNode, result);

        return result;
    }

    private static void traverseNetwork(Map<Integer, List<Integer>> networkGraph, Map<Integer, Integer> incomingEdgesCount,
            int currentNode, int targetNode, List<Integer> result) {
        if (incomingEdgesCount.getOrDefault(currentNode, 0) == 1 && currentNode != targetNode) {
            result.add(currentNode);
        }

        if (networkGraph.containsKey(currentNode)) {
            for (int childNode : networkGraph.get(currentNode)) {
                traverseNetwork(networkGraph, incomingEdgesCount, childNode, targetNode, result);
            }
        }
    }

    public static void main(String[] args) {
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 6 }, { 2, 4 }, { 4, 6 }, { 4, 5 }, { 5, 7 } };
        int targetNode = 4;

        List<Integer> affectedNodes = retrieveNodesWithSingleTargetAsParent(connections, targetNode);

        System.out.print("Nodes that have only " + targetNode + " as their parent: {");
        for (int i = 0; i < affectedNodes.size(); i++) {
            System.out.print(affectedNodes.get(i));
            if (i < affectedNodes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
