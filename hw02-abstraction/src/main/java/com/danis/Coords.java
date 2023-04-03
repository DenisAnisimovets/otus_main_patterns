package com.danis;

public class Coords {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coords plus(Coords position, Coords velocity) {
        return new Coords(
                position.getX() + velocity.getX(),
                position.getY() + velocity.getY()
        );
    }
}
