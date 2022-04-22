public class StateBottom extends State{
    @Override
    public void top(Snake stateOwner) {
    }

    @Override
    public void right(Snake stateOwner) {
        stateOwner.setCurrentState(new StateRight());
        stateOwner.setDx(1);
        stateOwner.setDy(0);
    }

    @Override
    public void left(Snake stateOwner) {
        stateOwner.setCurrentState(new StateLeft());
        stateOwner.setDx(-1);
        stateOwner.setDy(0);
    }

    @Override
    public void bottom(Snake stateOwner) {
    }
}
