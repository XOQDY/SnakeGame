public class Cell {

    private boolean head;
    private boolean snake;
    private boolean food;

    public Cell() {
        head = false;
        snake = false;
        food = false;
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

    public void setHead(boolean head) {
        this.head = head;
    }

    public void setSnake(boolean snake) {
        this.snake = snake;
    }

    public void setFood(boolean food) {
        this.food = food;
    }
}
