// Given the root of a tree, you are asked to find the most frequent subtree sum. 
// The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, 
// return all the values with the highest frequency in any order.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> map;
    int maxCount;
    List<Integer> res;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        maxCount = 0;
        res = new ArrayList<>();
        sum(root);
        int[] nums = new int[res.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }
    
    public int sum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + sum(root.left) + sum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > maxCount) {
            maxCount = map.get(sum);
            res = new ArrayList<>();
            res.add(sum);
        } else if (map.get(sum) == maxCount) {
            res.add(sum);
        }
        return sum;
    }
}
