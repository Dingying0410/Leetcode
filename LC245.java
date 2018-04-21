class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dis = Integer.MAX_VALUE;
        int one = -1;
        int two = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word2.equals(word1) && one != -1) {
                    dis = Math.min(dis, i - one);
                }
                one = i;
                if (two != -1) {
                    dis = Math.min(i - two, dis);
                }
            } else if (words[i].equals(word2)) {
                two = i;
                if (one != -1)
                    dis = Math.min(i - one, dis);
            }
        }
        return dis;
    }
}