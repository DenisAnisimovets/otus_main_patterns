package danis.command;

import danis.domain.FuelCheckable;
import danis.exception.CommandException;

public class CheckFuelCommand implements Command {
    private final FuelCheckable fuelCheckable;

    public CheckFuelCommand(FuelCheckable fuelCheckable) {
        this.fuelCheckable = fuelCheckable;
    }

    @Override
    public void execute() {
        if (fuelCheckable == null) {
            throw new CommandException("Object is null");
        }
        if (fuelCheckable.getFuelLevel() < fuelCheckable.getFuelBurnVelocity()) {
            throw new CommandException("Not enough fuel");
        }
    }
}
