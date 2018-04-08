class Solution {
    class TrieNode {
        List<String> startsWith;
        TrieNode[] nodes;
        
        public TrieNode() {
            startsWith = new ArrayList<>();
            nodes = new TrieNode[26];
        }
    }
    
    TrieNode root; 
    
    public void buildTrie (String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.nodes[c - 'a'] == null)
                    cur.nodes[c - 'a'] = new TrieNode();
                cur = cur.nodes[c - 'a'];
                cur.startsWith.add(s);
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode();
        List<List<String>> res = new ArrayList<>();
        buildTrie(words);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
            helper(res, list, words[i]);
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    public void helper (List<List<String>> res, List<String> list, String word) {
        if (list.size() == word.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i).charAt(size));
        }
        String start = sb.toString();
        TrieNode cur = root;
        for (char c : start.toCharArray()) {
            if (cur.nodes[c - 'a'] == null)
                return;
            cur = cur.nodes[c - 'a'];
        }
        for (String next : cur.startsWith) {
            list.add(next);
            helper(res, list, next);
            list.remove(list.size() - 1);
        }
    }
}