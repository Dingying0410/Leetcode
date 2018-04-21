class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int dis = Integer.MAX_VALUE;
        if (!map.containsKey(word1) || !map.containsKey(word2))
            return -1;
        int i = 0, j = 0;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        while (i < list1.size() && j < list2.size()) {
            dis = Math.min(dis, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return dis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */