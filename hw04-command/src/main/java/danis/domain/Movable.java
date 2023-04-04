package danis.domain;

import danis.domain.Coords;

public interface Movable {
    Coords getPosition();
    Coords getVelocity();
    void setPosition(Coords coords);
}
