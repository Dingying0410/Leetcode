class RandomizedSet {

    //We might use a hash set, but to get random, the time is O(n)
    //So we might use a list instead, which can help us to get by index
    //So we have to remember the index of each number, so that the time for remove is O(1)

    Map<Integer, Integer> map;
    List<Integer> list;
    Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int pos = map.get(val);
        if (pos != list.size() - 1) {
            list.set(pos, list.get(list.size() - 1));
            map.put(list.get(pos), pos);
        }
        //Remove
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = r.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
