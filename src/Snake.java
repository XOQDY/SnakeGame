public class Snake {

    private static final int CELL_PIXEL_SIZE = 30;

    private State currentState;

    private int x;
    private int y;
    private int dx;
    private int dy;

    public Snake(int x, int y, int dx, int dy) {
        currentState = new StateRight();
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public void top () {
        currentState.top(this);
    }

    public void right () {
        currentState.right(this);
    }

    public void left () {
        currentState.left(this);
    }

    public void bottom () {
        currentState.bottom(this);
    }
}
