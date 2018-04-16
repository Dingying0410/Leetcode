class Solution {
    //76.59%
    public String getPermutation(int n, int k) {
        //if n = 4, then we have 1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143...
        //choose the first number, divide by (n - 1)!
        //k = 8 -> k = 7 --> the first number is 1 -> 2
        //then we are going to find the second number starting with 2 (k - (n - 1)! = 1)
        //1 / 2 = 0 --> choose 1, then we have 21
        //then we are going to choose the k - (n - 1)! = 1 - 1 = 0 (first) number starting from 21...
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int fac = 1;
        for (int i = 2; i <= n - 1; i++) {
            fac *= i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / fac;
            sb.append(list.get(index));
            list.remove(index);
            k -= index * fac; //how many numbers before the current starting digit, like after we append 2, we need to know how many numbers are there starting with 1
            if (n - 1 - i != 0)
                fac /= (n - 1 - i);
        }
        return sb.toString();
    }
}