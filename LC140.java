class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0)
            return new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<>();
        return dfs(map, s, wordDict);
    }
    
    //For each word in the dict, check if s starts with the word
    //If yes, then do a dfs on the rest part of the word
    
    public List<String> dfs (Map<String, List<String>> map, String s, List<String> wordDict) {
        if (s.length() == 0) {
            return Arrays.asList("");
        }
        if (!map.containsKey(s)) {
            List<String> res = new ArrayList<>();
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    List<String> subList = dfs(map, s.substring(word.length()), wordDict);
                    for (String sub : subList) {
                        res.add(word + (sub.length() > 0? " " + sub : ""));
                    }
                }
            }
            map.put(s, res);
        }
        return map.get(s);
    }
}