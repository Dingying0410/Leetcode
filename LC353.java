class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    int[][] food;
    int width;
    int height;
    int score;
    int foodIndex;
    Set<Integer> set;
    Deque<Integer> queue;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        queue = new LinkedList<>();
        set = new HashSet<>();
        score = 0;
        foodIndex = 0;
        queue.offerLast(0);
        set.add(0);
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int head = queue.peekLast();
        int row = head / width;
        int col = head % width;
        switch (direction) {
            case "U":
                row--;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
                break;
            case "D":
                row++;
                break;
        }

        int newHead = row * width + col;
        //It is legal for the new head to be in the old tail's position
        set.remove(queue.peekFirst());
        if (row < 0 || row == height || col < 0 || col == width || set.contains(newHead)) {
            return -1;
        }
        set.add(newHead);
        queue.offerLast(newHead);
        if (foodIndex < food.length && row == food[foodIndex][0] && col == food[foodIndex][1]) {
            score++;
            foodIndex++;
            set.add(queue.peekFirst());
            return score;
        }
        queue.pollFirst();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
