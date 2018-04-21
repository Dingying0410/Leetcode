class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        for (int i = 0; i < (num.length() + 1) / 2; i++) {
            int j = num.length() - 1 - i;
            if (i == j) {
                if (num.charAt(i) == '6' || num.charAt(i) == '9')
                    return false;
            }
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j))
                return false;
        }
        return true;
    }
}