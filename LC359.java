class Logger {

    Map<String, Queue<Integer>> map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean res = false;
        if (!map.containsKey(message)) {
            res = true;
            map.put(message, new LinkedList<>());
            map.get(message).add(timestamp);
        } else {
            Queue<Integer> queue = map.get(message);
            if (queue.isEmpty() || queue.peek() <= timestamp - 10) {
                res = true;
                while (!queue.isEmpty() && queue.peek() <= timestamp - 10) {
                    queue.poll();
                }
                queue.offer(timestamp);
            }
            map.put(message, queue);
        }
        return res;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
