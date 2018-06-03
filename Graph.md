### 1. Sequence reconstruction  
+ The idea is to use topological sort. For each sequence, we process the in degree and the next node for each node. Then we find a node with in degree of 0, add it to the queue each time.  
+ At last we need to make sure if the nodes that are pooled from the queue follow the order of the original sequence, and whether all the nodes have been processed.
+ Some test cases
```
[1,2]
[[1,2],[1,2]]
```
This requires us to use a **hash set** to store the next nodes for each node. Also, we need to check whether 2 has been added to the set of 1
```java
if (map.get(a).add(b)) {
    inDegree.put(b, inDegree.get(b) + 1);
}
```
```
[5,3,2,4,1]
[[5,3,2,4],[4,1],[1],[3],[2,4]
[1,1000000000]]
```
This requires us to store every node in the map (in-degree), though it is not in the original sequence.

+ Similar questions
