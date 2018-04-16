class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, new StringBuilder(), 0, 0, 0);
        return res;
    }
    
    public void dfs (List<String> res, String s, StringBuilder sb, int pos, int dots, int num) {
        if (pos == s.length()) {
            if (dots == 3) {
                res.add(sb.toString());
            }
            return;
        }
        
        if (num * 10 + (s.charAt(pos) - '0') <= 255) {
            if (num > 0 || pos == 0 || sb.charAt(sb.length() - 1) == '.') { //avoid leading zero
                sb.append(s.charAt(pos));
                dfs(res, s, sb, pos + 1, dots, num * 10 + (s.charAt(pos) - '0'));
                sb.setLength(sb.length() - 1);
            }
        }
        if (pos > 0 && dots < 3) {
            //if (num * 10 + (s.charAt(pos) - '0') == 0 && )
            sb.append(".");
            sb.append(s.charAt(pos));
            dfs(res, s, sb, pos + 1, dots + 1, s.charAt(pos) - '0');
            sb.setLength(sb.length() - 2);
        }
    }
}