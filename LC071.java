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

    //Version 2: Faster version using deque, beat 80%
    //Might be because the time for stringBuilder insert is slow?
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals("")) {
                continue;
            } else if (strs[i].equals("..")) {
                if (!queue.isEmpty()) 
                    queue.removeLast();  //poll from the end
            } else {
                queue.addLast(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String poll = queue.removeFirst();
            sb.append("/" + poll);
        }
        return sb.length() == 0? "/" : sb.toString();
    }
}