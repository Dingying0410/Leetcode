class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input.indexOf('+') == -1 && input.indexOf('-') == -1 && input.indexOf('*') == -1) {
            res.add(Integer.valueOf(input));
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> subList1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> subList2 = diffWaysToCompute(input.substring(i + 1));
                char c = input.charAt(i);
                for (int num1 : subList1) {
                    for (int num2 : subList2) {
                        switch (c) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }
}