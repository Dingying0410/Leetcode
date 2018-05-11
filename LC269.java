class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> next = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    inDegree.put(b.charAt(j), inDegree.get(b.charAt(j)) + 1);
                    if (!next.containsKey(a.charAt(j))) {
                        next.put(a.charAt(j), new ArrayList<>());
                    }
                    next.get(a.charAt(j)).add(b.charAt(j));
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Character key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (next.containsKey(c)) {
                for (char temp : next.get(c)) {
                    inDegree.put(temp, inDegree.get(temp) - 1);
                    if (inDegree.get(temp) == 0) {
                        queue.add(temp);
                    }
                }
            }
        }
        return sb.length() == inDegree.size()? sb.toString() : "";
    }
}
