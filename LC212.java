class Solution {
    class TrieNode {
        TrieNode[] nodes;
        String word;
        
        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void buildTrie (String[] words) {
        if (words.length == 0)
            return;
        if (root == null) {
            root = new TrieNode();
        }
        for (String word : words) {
            TrieNode cur = root;
            char[] chs = word.toCharArray();
            for (char c : chs) {
                if (cur.nodes[c - 'a'] == null)
                    cur.nodes[c - 'a'] = new TrieNode();
                cur = cur.nodes[c - 'a'];
            }
            cur.word = word;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0)
            return res;
        buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(res, board, i, j, m, n, root);
            }
        }
        return res;
    }
    
    public void search (List<String> res, char[][] board, int i, int j, int m, int n, TrieNode cur) {
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#' || cur.nodes[board[i][j] - 'a'] == null) {
            return;
        }
        cur = cur.nodes[board[i][j] - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        int[] delta = {0, -1, 0, 1, 0};
        for (int k = 0; k < delta.length - 1; k++) {
            search(res, board, i + delta[k], j + delta[k + 1], m, n, cur);
        }
        board[i][j] = temp;
    }
}