package com.danis.model;

public interface Movable {
    Coords getPosition();

    Coords getVelocity();

    void setPosition(Coords newValue);
}
