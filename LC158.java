/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] file;
    int head = 0, tail = 0;
    
    public int read(char[] buf, int n) {
        int total = 0;
        boolean end = false;
        while (total < n && !end) {
            if (head == tail) {
                file = new char[4];
                tail = read4(file);
                head = 0;
            }
            if (tail < 4)
                end = true;
            while (head < tail && total < n) {
                buf[total++] = file[head++];
            }
        }
        return total;
    }
}