/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        return dfs(node);
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (!map.containsKey(node.label)) {
            map.put(node.label, new UndirectedGraphNode(node.label));
            for (UndirectedGraphNode next : node.neighbors) {
                map.get(node.label).neighbors.add(dfs(next));
            }
        }
        return map.get(node.label);
    }
}