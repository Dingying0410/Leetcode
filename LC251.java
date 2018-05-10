public class Vector2D implements Iterator<Integer> {

    int row;
    int col;
    List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        row = 0;
        col = 0;
        for (int i = 0; i < vec2d.size(); i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                list.get(i).add(vec2d.get(i).get(j));
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(row).get(col++);
    }

    @Override
    public boolean hasNext() {
        while (row < list.size()) {
            if (col < list.get(row).size()) {
                return true;
            } else {
                row++;
                col = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */