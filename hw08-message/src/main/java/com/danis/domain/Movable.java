package com.danis.domain;

public interface Movable {
    Coords getPosition();

    Coords getVelocity();

    void setPosition(Coords newValue);
}
