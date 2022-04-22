import java.util.ArrayList;
import java.util.List;

public class Snake {

    private State currentState;

    private List<Cell> snake = new ArrayList<Cell>();

    private int x;
    private int y;
    private int dx;
    private int dy;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 1;
        this.dy = 0;
        currentState = new StateLeftRight();
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public void up() {
        currentState.up(this);
    }

    public void right() {
        currentState.right(this);
    }

    public void left() {
        currentState.left(this);
    }

    public void down() {
        currentState.down(this);
    }

    public void move(Cell cell) {
        snake.remove(0);
        addCell(cell);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void addCell(Cell cell) {
        this.snake.add(cell);
    }
}
