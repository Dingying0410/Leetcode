class Solution {
    public int smallestFactorization(int a) {
        if (a == 1)
            return 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                a /= i;
                list.add(0, i);
            }
        }
        if (a != 1)
            return 0;
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = res * 10 + list.get(i);
            if (res > (long)Integer.MAX_VALUE)
                return 0;
        }
        return (int)res;
    }
}