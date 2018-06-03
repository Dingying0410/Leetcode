## Output rectangle area coordinates

Given an array of numbers with 0, 1, where 0 represents areas with rectangles, return the left upper corner and right bottom corner coordinates of each rectangle.   
```
Eg. {{1, 1, 1, 1, 1, 1},
    {0, 0, 1, 0, 1, 1},
    {0, 0, 1, 0, 1, 0},
    {1, 1, 1, 0, 1, 0},
    {1, 0, 0, 1, 1, 1}};

Output:
    [1, 0, 2, 1]
    [1, 3, 3, 3]
    [2, 5, 3, 5]
    [4, 1, 4, 2]
```

```java
public List<int[]> rectangles (int[][] grid) {
    List<int[]> res = new ArrayList<>();
    if (grid.length == 0 || grid[0].length == 0)
      return res;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          int[] cordinates = new int[4];
          cordinates[0] = cordinates[2] = i;
          cordinates[1] = cordinates[3] = j;
          dfs(grid, i, j, cordinates);
          res.add(cordinates);
        }
      }
    }
    return res;
  }

  public void dfs (int[][] grid, int i, int j, int[] cordinates) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 1) {
      //list.add(new int[]{startRow, startCol, endRow, endCol});
      return;
    }
    cordinates[0] = Math.min(cordinates[0], i);
    cordinates[1] = Math.min(cordinates[1], j);
    cordinates[2] = Math.max(cordinates[2], i);
    cordinates[3] = Math.max(cordinates[3], j);
    grid[i][j] = 1;
    int[] delta = {0, -1, 0, 1, 0};
    for (int k = 0; k < delta.length - 1; k++) {
      dfs(grid, i + delta[k], j + delta[k + 1], cordinates);
    }
  }
```
