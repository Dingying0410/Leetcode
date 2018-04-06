//Time: O(n) n = the number of nuts
//Space: O(1)

//Idea: the squirrel has to go back to the tree after he gets a nut each time
//Suppose he starts at the tree, then the total distance = 2 * sum(distance(nuts[i], tree))
//Now we want it to start at the original starting place, then the difference would be:
//distance(nuts[j], start point) - distance(nuts[j], tree)
//find the one with minimum diff

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dis = 0;
        int diff = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            //if start from the tree
            dis += Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            //difference with start from the original place, choose the first nut as the one that is closest to the starting point
            diff = Math.min(diff, Math.abs(squirrel[0] - nut[0]) + Math.abs(squirrel[1] - nut[1]) - 
                            Math.abs(tree[0] - nut[0]) - Math.abs(tree[1] - nut[1]));
        }
        
        int sum = 2 * dis;
        return sum + diff;
    }
}