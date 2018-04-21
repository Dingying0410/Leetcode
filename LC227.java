class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int diff = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (stack.isEmpty()) {
                    stack.push(num);
                    diff = num;
                }  
                else {
                    switch (op) {
                        case '+':
                            stack.push(num + stack.pop());
                            diff = num;
                            break;
                        case '-':
                            stack.push(stack.pop() - num);
                            diff = -num;
                            break;
                        case '*':
                            stack.push(stack.pop() - diff + diff * num);
                            diff = diff * num;
                            break;
                        case '/':
                            stack.push(stack.pop() - diff + diff / num);
                            diff = diff / num;
                            break;
                    }
                }
                num = 0;
                i--;
            } else if (c == ' ') 
                continue;
            else {
                op = c;
            }
        }
        return stack.pop();
    }
}