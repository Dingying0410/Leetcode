class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //divide, mod, if mod = 0, finish
        //if mod > 0, then put to map, and mod *= 10
        if (numerator == 0) {
            return "0";
        }
        boolean neg = (numerator > 0) ^ (denominator > 0);
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        if (denominator == 0) {
            return neg? Integer.MIN_VALUE + "": Integer.MAX_VALUE + "";
        }
        StringBuilder sb = new StringBuilder();
        long mod = num % den;
        sb.append(num / den);
        if (mod == 0) {
            return (neg? "-" : "") + sb.toString();
        } else {
            sb.append(".");
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(mod, sb.length());
        while (mod != 0) {
            num = mod * 10;
            sb.append(num / den);
            if (map.containsKey(num % den)) {
                sb.insert(map.get(num % den), "(");
                sb.append(")");
                break;
            } else {
                map.put(num % den, sb.length());
            }
            mod = num % den;
        }
        return (neg? "-" : "") + sb.toString();
    }
}