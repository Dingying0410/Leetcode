class MyCalendar {

    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<int[]>((a, b) -> (a[0] - b[0]));
    }

    public boolean book(int start, int end) {
        int[] nums = {start, end};
        int[] floor = set.floor(nums);
        if (floor != null && floor[1] > start) return false;
        int[] ceil = set.ceiling(nums);
        if (ceil != null && ceil[0] < end) return false;
        set.add(nums);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
