public class ZigzagIterator {

    int k;
    int j1, j2;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        j1 = 0;
        j2 = 0;
        k = 0;

    }

    public int next() {
        int res = -1;
        //System.out.println(j1 + " " + j2);
        if ((k % 2 == 0 && j1 < v1.size()) || j2 == v2.size())
            res = v1.get(j1++);
        else
            res = v2.get(j2++);
        k++;
        return res;
    }

    public boolean hasNext() {
        return j1 < v1.size() || j2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
