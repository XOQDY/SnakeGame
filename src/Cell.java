public class Cell {

    private boolean head;
    private boolean snake;
    private boolean food;
    private boolean wall;

    public Cell() {
        head = false;
        snake = false;
        food = false;
        wall = false;
    }

    public boolean isHead() {
        return head;
    }

    public boolean isSnake() {
        return snake;
    }

    public boolean isFood() {
        return food;
    }

    public boolean isWall() {
        return wall;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public void setSnake(boolean snake) {
        this.snake = snake;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
}
