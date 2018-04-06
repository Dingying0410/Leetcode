//Time: O(n)
//Space: O(1)

class Solution {
    public int findUnsortedSubarray(int[] A) {
        int n = A.length;
        int end = -2, start = -1, max = A[0], min = A[n - 1];
        for (int i = 0; i < n; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[n - 1 - i], min);
            if (A[i] < max) 
                end = i;
            if (A[n - i - 1] > min)
                start = n - i - 1;
        }
        return end - start + 1;
    }
}
