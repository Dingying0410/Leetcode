class Solution {
    //Version 1: priority queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                int top = pq.peek();
                if (nums[i] > top) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.poll();
    }

    //Version 2: quick select
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return findKthSmallest(nums, k, 0, nums.length - 1);
    }
    
    public int findKthSmallest(int[] nums, int k, int low, int high) {
        int index = quickSelect(nums, low, high);
        if (index == k)
            return nums[k];
        else if (index > k) {
            return findKthSmallest(nums, k, low, index - 1);
        } else {
            return findKthSmallest(nums, k, index + 1, high);
        }
    }
    
    public int quickSelect (int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(i, j, nums);
            }
        }
        if (nums[i + 1] != pivot) {
            swap(i + 1, high, nums);
        }
        return i + 1;
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}