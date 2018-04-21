class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int one = -1; 
        int two = -1;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                one = i;
                if (two != -1) {
                    dis = Math.min(dis, i - two);
                }
            } else if (words[i].equals(word2)) {
                two = i;
                if (one != -1) {
                    dis = Math.min(dis, i - one);
                }
            }
        }
        return dis;
    }
}