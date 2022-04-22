public abstract class State {
    public abstract void top(Snake stateOwner);
    public abstract void right(Snake stateOwner);
    public abstract void left(Snake stateOwner);
    public abstract void bottom(Snake stateOwner);
}
