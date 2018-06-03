## 411. Minimum Unique Word Abbreviation
```java
class Solution {
    class TrieNode {
        TrieNode[] nodes;
        boolean word;

        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }

    TrieNode root;

    public void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.nodes[word.charAt(i) - 'a'] == null) {
                    cur.nodes[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.nodes[word.charAt(i) - 'a'];
            }
            cur.word = true;
        }
    }

    public boolean find (String word, TrieNode cur, int start, int loop) {
        if (cur == null)
            return false;

        if (loop > 0) {
            for (TrieNode next : cur.nodes) {
                if (find(word, next, start, loop - 1))
                    return true;
            }
            return false;
        }
        if (start == word.length())
            return cur.word;
        char c = word.charAt(start);
        if (c >= 'a' && c <= 'z') {
            if (find(word, cur.nodes[c - 'a'], start + 1, loop))
                return true;
        } else {
            int num = 0;
            int i = start;
            while (i < word.length() && word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                num = num * 10 + word.charAt(i) - '0';
                i++;
            }
            if (find(word, cur, i, num))
                return true;
        }
        return false;
    }

    public void generateAbbr (List<String> res, int len, String word, int start, int num, String cur) {
        if (start == word.length()) {
            if ((len == 0 && num == 0) || (len == 1 && num > 0))
                res.add(cur + (num > 0? num : ""));
            return;
        }
        generateAbbr(res, (num > 0? len - 2 : len - 1), word, start + 1, 0, cur + (num > 0? num : "") + word.charAt(start));
        generateAbbr(res, len, word, start + 1, num + 1, cur);
    }

    public String minAbbreviation(String target, String[] dictionary) {
        root = new TrieNode();
        buildTrie(dictionary);
        for (int len = 1; len <= target.length(); len++) {
            List<String> list = new ArrayList<>();
            generateAbbr(list, len, target, 0, 0, "");
            for (String s : list) {
                TrieNode cur = root;
                if (!find(s, cur, 0, 0))
                    return s;
            }
        }
        return "";
    }
}
```
