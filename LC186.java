class Solution {
    public void reverseWords(char[] str) {
        //rotate the whole array
        reverse(0, str.length - 1, str);
        //identify the string and rotate each string
        int i = 0;
        while (i < str.length) {
            while (i < str.length && str[i] == ' ') {
                i++;
            }
            int start = i;
            while (i < str.length && str[i] != ' ') {
                i++;
            }
            reverse(start, i - 1, str);
        }
    }
    
    public void reverse (int i, int j, char[] str) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++; j--;
        }
    }
}