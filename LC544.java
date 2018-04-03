class Solution {
    public String findContestMatch(int n) {
        return helper(n, 1, n);
    }
    
    public String helper (int n, int start, int end) {
        if (n == 2) {
            return "(" + start + "," + end + ")";
        }
        String res = "";
        int sum = start + end;
        res += "(" + helper(n / 2, start, end) + ",";
        res += helper(n / 2, n + 1 - start, sum - (n + 1 - start)) + ")";
        return res;
    }
}