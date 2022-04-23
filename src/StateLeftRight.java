public class StateLeftRight extends State{
    @Override
    public void up(Snake stateOwner) {
        stateOwner.setCurrentState(new StateUpDown());
        stateOwner.setDx(0);
        stateOwner.setDy(-1);
    }

    @Override
    public void right(Snake stateOwner) {
    }

    @Override
    public void left(Snake stateOwner) {
    }

    @Override
    public void down(Snake stateOwner) {
        stateOwner.setCurrentState(new StateUpDown());
        stateOwner.setDx(0);
        stateOwner.setDy(1);
    }
}
