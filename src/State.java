public abstract class State {
    public abstract void up(Snake stateOwner);
    public abstract void right(Snake stateOwner);
    public abstract void left(Snake stateOwner);
    public abstract void down(Snake stateOwner);
}
