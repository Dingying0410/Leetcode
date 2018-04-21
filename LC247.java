class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n , n);
    }
    
    public List<String> helper (int m, int n) {
        if (n == 0) {
            return Arrays.asList("");
        } else if (n == 1) {
            return Arrays.asList("1", "0", "8");
        }
        List<String> subList = helper(m, n - 2); 
        List<String> res = new ArrayList<>();
        for (String sub : subList) {
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("9" + sub + "6");
            res.add("8" + sub + "8");
            if (m != n)
                res.add("0" + sub + "0");
        }
        return res;
    }
}