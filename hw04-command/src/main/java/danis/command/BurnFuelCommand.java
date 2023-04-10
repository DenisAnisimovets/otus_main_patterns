package danis.command;

import danis.domain.FuelBurnable;
import danis.exception.CommandException;

public class BurnFuelCommand implements Command {
    private final FuelBurnable fuelBurnable;

    public BurnFuelCommand(FuelBurnable fuelBurnable) {
        this.fuelBurnable = fuelBurnable;
    }

    @Override
    public void execute() {
        if(fuelBurnable == null) {
            throw new CommandException("Object is null");
        }
        int newLevel = fuelBurnable.getFuelLevel() - fuelBurnable.getFuelBurnVelocity();
        if(newLevel < 0) {
            throw new CommandException("Not enough fuel");
        }
        fuelBurnable.setFuelLevel(newLevel);
    }
}
