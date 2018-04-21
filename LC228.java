class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        int start = nums[0];
        int end = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end++;
            } else {
                res.add(getStr(start, end));
                start = end = nums[i];
            }
        }
        res.add(getStr(start, end));
        return res;
    }
    
    public String getStr (int start, int end) {
        if (start == end) 
            return start + "";
        return start + "->" + end;
    }
}