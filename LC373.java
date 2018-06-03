class Solution {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare (int[] a, int[] b) {
                return a[0] + a[1] - (b[0] + b[1]);
            }
        });

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!pq.isEmpty() && res.size() < k) {
            int[] cur = pq.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] < nums2.length - 1) {
                pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }

        return res;
    }
}
