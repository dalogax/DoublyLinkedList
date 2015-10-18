package com.dalogax.orchestra;

/**
 * Created with IntelliJ IDEA.
 * User: dalogax@gmail.com
 * Date: 18/10/15
 * Time: 21:04
 */
public class Sit {
    private boolean occupied;
    private int id;

    public Sit() {
        occupied = false;
    }

    public Sit(boolean occupied, int id) {
        this.occupied = occupied;
        this.id = id;
    }

    public Sit(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
