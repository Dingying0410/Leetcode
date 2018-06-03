class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    Queue<Integer> available;
    Set<Integer> used;
    int maxNumber;

    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<>();
        used = new HashSet<>();
        this.maxNumber = maxNumbers;
        for (int i = 0; i < maxNumber; i++) {
            available.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.isEmpty())
            return -1;
        int num = available.poll();
        used.add(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!used.contains(number))
            return;
        used.remove(number);
        available.offer(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
