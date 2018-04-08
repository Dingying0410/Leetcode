class Solution {
    int[] hours = {1, 2, 4, 8};
    int[] minutes = {1, 2, 4, 8, 16, 32};
    
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hs = new ArrayList<Integer>();
            List<Integer> ms = new ArrayList<Integer>();
            generateTimes(hs, i, hours, 0, 0);
            generateTimes(ms, num - i, minutes, 0, 0);
            for (int h : hs) {
                if (h > 11) continue;
                for (int m : ms) {
                    if (m > 59) continue;
                    res.add(h + ":" + (m < 10? "0" + m : m));
                }
            }
        }
        return res;
    }
    
    public void generateTimes (List<Integer> list, int n, int[] nums, int sum, int start) {
        if (n == 0) {
            list.add(sum);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            generateTimes(list, n - 1, nums, sum + nums[i], i + 1);
        }
    }
}