class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join("-", sentence) + "-";
        int nCols = 0;
        for (int i = 0; i < rows; i++) {
            nCols += cols;
            if (s.charAt(nCols % s.length()) == '-')
                nCols++;  //actually using (nCols + 1) space
            while (nCols > 0 && s.charAt((nCols - 1) % s.length()) != '-')
                nCols--;
        }
        return nCols / s.length();
     }
}