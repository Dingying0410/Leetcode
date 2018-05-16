class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, "", 0, 0);
        return res;
    }

    public void helper(List<String> res, String word, String cur, int i, int num) {
        if (i == word.length()) {
            res.add((num > 0? (cur + num) : cur));
            num = 0;
            return;
        }
        char c = word.charAt(i);
        helper(res, word, cur + (num > 0? num : "") + c, i + 1, 0);
        helper(res, word, cur, i + 1, num + 1);
    }
}
