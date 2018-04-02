class Solution {
    public String complexNumberMultiply(String a, String b) {
        int idx1 = a.indexOf('+');
        int idx2 = b.indexOf('+');
        int real1 = Integer.valueOf(a.substring(0, idx1));
        int real2 = Integer.valueOf(b.substring(0, idx2));
        int i1 = a.indexOf('i');
        int i2 = b.indexOf('i');
        int com1 = Integer.valueOf(a.substring(idx1 + 1, i1));
        int com2 = Integer.valueOf(b.substring(idx2 + 1, i2));
        int first = real1 * real2 - com1 * com2;
        int second = real1 * com2 + real2 * com1;
        return first + "+" + second + "i";
    }
}