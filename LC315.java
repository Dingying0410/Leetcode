class Solution {
    class Node {
        int small;
        int dup;
        int val;
        Node left;
        Node right;

        public Node (int val) {
            this.dup = 1;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer[] smalls = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = buildTree(root, nums[i], 0, smalls, i);
        }
        return Arrays.asList(smalls);
    }

    public Node buildTree (Node root, int val, int small, Integer[] nums, int i) {
        if (root == null) {
            root = new Node(val);
            nums[i] = small;
        } else if (root.val < val) {
            root.right = buildTree(root.right, val, small + root.dup + root.small, nums, i);
        } else if (root.val > val) {
            root.small++;
            root.left = buildTree(root.left, val, small, nums, i);
        } else {
            root.dup++;
            nums[i] = small + root.small;
        }
        return root;
    }
}
