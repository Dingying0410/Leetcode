class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", target, num, 0, 0, 0);
        return res;
    }

    public void helper (List<String> res, String cur, int target, String num, int start, long curSum, long diff) {
        if (start == num.length()) {
            if (target == curSum) {
                res.add(cur);
            }
            return;
        }
        for (int len = 1; start + len <= num.length(); len++) {
            String temp = num.substring(start, start + len);
            if (temp.length() > 1 && temp.charAt(0) == '0')
                continue;
            if (cur.length() == 0) {
                helper(res, cur + temp, target, num, start + len, Long.valueOf(temp), Long.valueOf(temp));
            } else {
                helper(res, cur + "+" + temp, target, num, start + len, curSum + Long.valueOf(temp), Long.valueOf(temp));
                helper(res, cur + "-" + temp, target, num, start + len, curSum - Long.valueOf(temp), -Long.valueOf(temp));
                helper(res, cur + "*" + temp, target, num, start + len, curSum - diff + diff * Long.valueOf(temp), diff * Long.valueOf(temp));
            }
        }
    }
}
