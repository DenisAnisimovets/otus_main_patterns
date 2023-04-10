package danis.command;

import danis.domain.Rotatable;

public class RotateCommand implements Command {
    private final Rotatable rotatable;

    public RotateCommand(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    @Override
    public void execute() {
        if (rotatable == null) {
            throw new IllegalStateException("Object is null");
        }
        if (rotatable.getDirectionsNum() == 0) {
            throw new IllegalStateException("Directions num is zero");
        }
        rotatable.setDirection((rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getDirectionsNum());
    }
}
