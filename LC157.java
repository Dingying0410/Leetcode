/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    //Case 1: n = 9, but only 7 characters to read
    //Case 2: n = 9, file is 10
    public int read(char[] buf, int n) {
        int total = 0;
        boolean end = false;
        while (total < n && !end) {
            char[] file = new char[4];
            int cur = read4(file);
            if (cur < 4)
                end = true;
            int remain = n - total;
            for (int i = 0; i < Math.min(cur, remain); i++) {
                buf[total++] = file[i];
            }
        }
        return total;
    }
}