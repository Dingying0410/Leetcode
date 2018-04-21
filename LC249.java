class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            if (str.length() == 0)
                continue;
            int diff = str.charAt(0) - 'a';
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = (char)(chs[i] - diff);
                if (c < 'a')
                    c = (char)(c + 26); 
                chs[i] = c;
            }
            String mapStr = new String(chs);
            if (!map.containsKey(mapStr)) {
                map.put(mapStr, new ArrayList<String>());
            }
            map.get(mapStr).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}