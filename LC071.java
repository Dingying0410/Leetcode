class Solution {
    public String simplifyPath(String path) {
        //Define what should be skipped
        Set<String> skip = new HashSet<>(Arrays.asList(".", "", ".."));
        //convert to array
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(strs[i])){
                stack.push(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.length() == 0? "/" : sb.toString();
    }
}