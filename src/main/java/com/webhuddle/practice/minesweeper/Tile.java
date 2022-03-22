package com.webhuddle.practice.minesweeper;


import java.awt.*;
import java.util.Objects;

public class Tile {
    private boolean mine;
    private boolean revealed;
    private int nearbyMines;
    private Point point;

    public Tile(Point point){
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public int getNearbyMines() {
        return nearbyMines;
    }

    public void setNearbyMines(int nearbyMines) {
        this.nearbyMines = nearbyMines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return mine == tile.mine && revealed == tile.revealed && nearbyMines == tile.nearbyMines && point.equals(tile.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mine, revealed, nearbyMines, point);
    }
}
