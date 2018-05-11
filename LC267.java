class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int odd = 0;
        char mid = ' ';
        List<Character> list = new ArrayList<>();
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odd++;
                mid = key;
            }
            for (int i = 0; i < map.get(key) / 2; i++) {
                    list.add(key);
            }
        }
        Set<String> res = new HashSet<>();
        if (odd > 1)
            return new ArrayList<>();
        Collections.sort(list);
        helper(res, new StringBuilder(), mid, list, new boolean[list.size()]);
        return new ArrayList<>(res);
    }

    public void helper (Set<String> res, StringBuilder sb, char mid, List<Character> list, boolean[] used) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + (mid == ' '? "" : mid) + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (used[i] || (i > 0 && list.get(i - 1).equals(list.get(i)) && !used[i - 1]))
                continue;
            used[i] = true;
            sb.append(list.get(i));
            helper(res, sb, mid, list, used);
            sb.setLength(sb.length() - 1);
            used[i] = false;
        }
    }
}
