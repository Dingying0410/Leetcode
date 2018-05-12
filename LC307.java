class NumArray {

    class Node {
        Node left;
        Node right;
        int start;
        int end;
        int sum;

        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public Node build(int[] nums, int start, int end) {
        if (start > end)
            return null;
        else {
            if (start == end) {
                Node node = new Node(start, end);
                node.sum = nums[start];
                return node;
            } else {
                int mid = start + (end - start) / 2;
                Node node = new Node(start, end);
                node.left = build(nums, start, mid);
                node.right = build(nums, mid + 1, end);
                node.sum = node.left.sum + node.right.sum;
                return node;
            }
        }
    }

    Node node;
    public NumArray(int[] nums) {
        node = build(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(node, i, val);
    }

    public void update (Node node, int i, int val) {
        if (node.start > i || node.end < i)
            return;
        else if (node.start == node.end && node.start == i) {
            node.sum = val;
        } else {
            int mid = (node.start + node.end) / 2;
            if (mid >= i) {
                update(node.left, i, val);
            } else {
                update(node.right, i, val);
            }
            node.sum = node.left.sum + node.right.sum;
            }
    }

    public int sumRange(int i, int j) {
        return sumRange(node, i, j);
    }

    public int sumRange(Node node, int start, int end) {
        if (start > node.end || end < node.start)
            return 0;
        else {
            //My range is larger than the node range
            if (node.start >= start && node.end <= end) {
                return node.sum;
            } else {
                int mid = (node.start + node.end) / 2;
                if (start >= mid + 1)
                    return sumRange(node.right, start, end);
                else if (end <= mid) {
                    return sumRange(node.left, start, end);
                } else {
                    return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
                }
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
