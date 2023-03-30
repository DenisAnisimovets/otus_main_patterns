package com.danis;

public interface Movable {
    Coords getPosition();
    Coords getVelocity();
    void setPosition(Coords coords);
}
