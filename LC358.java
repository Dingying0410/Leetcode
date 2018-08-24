class Solution {
    class Word {
        char c;
        int count;
        public Word(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>(){
            public int compare(Word a, Word b) {
                return b.count - a.count;
            }
        });
        for (char key : map.keySet()) {
            pq.offer(new Word(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        Queue<Word> wait = new LinkedList<>();
        while (!pq.isEmpty()) {
            Word cur = pq.poll();
            sb.append(cur.c);
            wait.offer(new Word(cur.c, cur.count));
            if (wait.size() >= k) {
                Word top = wait.poll();
                if (top.count > 1) {
                    pq.offer(new Word(top.c, top.count - 1));
                }
            }
        }
        return sb.length() == s.length()? sb.toString() : "";
    }
}
