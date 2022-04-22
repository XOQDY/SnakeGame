public class StateRight extends State{
    @Override
    public void top(Snake stateOwner) {
        stateOwner.setCurrentState(new StateTop());
        stateOwner.setDx(0);
        stateOwner.setDy(1);
    }

    @Override
    public void right(Snake stateOwner) {
    }

    @Override
    public void left(Snake stateOwner) {
    }

    @Override
    public void bottom(Snake stateOwner) {
        stateOwner.setCurrentState(new StateBottom());
        stateOwner.setDx(0);
        stateOwner.setDy(-1);
    }
}
