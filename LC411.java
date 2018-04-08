class Solution {
    class TrieNode {
        TrieNode[] nodes;
        boolean end;
        
        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public String minAbbreviation(String target, String[] dictionary) {
        root = new TrieNode();
        for (String d : dictionary) {
            buildTrie(d);
        }
        for (int i = 0; i < target.length(); i++) {
            List<String> list = new ArrayList<>();
            generate(list, i + 1, 0, "", target, 0);
            for (String s : list) {
                if (!search(root, s, 0, 0))
                    return s;
            }
        }
        return "";
    }
    
    public void generate (List<String> res, int len, int num, String cur, String target, int i) {
        if (i == target.length()) {
            if (num > 0) 
                cur += num;
            if (len == 0 || (num > 0 && len == 1))
                res.add(cur);
            num = 0;
            return;
        }
        if (len <= 0)
            return;
        char c = target.charAt(i);
        generate(res, num > 0? len - 2 : len - 1, 0, num > 0? cur + num + c : cur + c, target, i + 1);
        generate(res, len, num + 1, cur, target, i + 1);
    }
    
    public void buildTrie (String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (cur.nodes[s.charAt(i) - 'a'] == null) {
                cur.nodes[s.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.nodes[s.charAt(i) - 'a'];
        }
        cur.end = true;
    }
    
    public boolean search (TrieNode cur, String target, int i, int loop) {
        if (cur == null)
            return false;
        if (loop > 0) {
            for (TrieNode next : cur.nodes) {
                if (search(next, target, i, loop - 1)) return true;
            }
            return false;
        }
        if (i == target.length()) {
            return cur.end;
        }
        char c = target.charAt(i);
        if (Character.isDigit(c)) {
            int j = i;
            int num = 0;
            while (j < target.length() && Character.isDigit(target.charAt(j))) {
                num = num * 10 + target.charAt(j) - '0';
                j++;
            }
            return search(cur, target, j, num);
        } else {
            return search(cur.nodes[c - 'a'], target, i + 1, loop);
        }
    }
}