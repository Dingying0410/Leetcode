/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.indexOf('[') == -1)
            return new NestedInteger(Integer.valueOf(s));
        int l = 0;
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                l = i + 1;
            } else if (s.charAt(i) == ',') {
                String val = s.substring(l, i);
                if (val.length() > 0) {
                    cur.add(new NestedInteger(Integer.valueOf(val)));
                }
                l = i + 1;
            } else if (s.charAt(i) == ']') {
                if (l != i) {
                    String val = s.substring(l, i);
                    if (val.length() > 0) {
                        cur.add(new NestedInteger(Integer.valueOf(val)));
                    }
                }
                l = i + 1;
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(cur);
                    cur = pop;
                }
            }
        }
        return cur;
    }
}
