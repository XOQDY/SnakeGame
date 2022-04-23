public class Cell {

    private boolean snake;
    private boolean food;
    private boolean wall;

    public Cell() {
        snake = false;
        food = false;
        wall = false;
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
