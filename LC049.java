class Solution {
    //Time: O(m*nlogn), m = size of strs, n = size of string in the array
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs)
            String sort = new String(chs);
            if (!map.containsKey(sort))
                map.put(sort, new ArrayList<>());
            map.get(sort).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}