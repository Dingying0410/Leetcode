class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = -1;
        int num2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                cnt1++;
            } else if (nums[i] == num2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1++;
                num1 = nums[i];
            } else if (cnt2 == 0) {
                cnt2++;
                num2 = nums[i];
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1)
                cnt1++;
            else if (nums[i] == num2)
                cnt2++;
        }
        if (cnt1 > nums.length / 3)
            res.add(num1);
        if (cnt2 > nums.length / 3)
            res.add(num2);
        return res;
    }
}