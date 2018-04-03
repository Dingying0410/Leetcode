class Solution {
    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        for (int i = chs.length - 2; i >= 0; i--) {
            if (chs[i] < chs[i + 1]) {
                //Found increasing sequence
                for (int j = chs.length - 1; j > i; j--) {
                    if (chs[j] > chs[i]) {
                        
                        swap(chs, i, j);
                        reverse(chs, i + 1, chs.length - 1);
                        if (Long.valueOf(new String(chs)) > (long)Integer.MAX_VALUE)
                            return -1;
                        return Integer.valueOf(new String(chs));
                    }
                }
            }
        }
        return -1;
    }
    
    public void swap (char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse (char[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }
}