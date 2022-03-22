package com.webhuddle.practice.minesweeper;

import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    Tile[][] tiles;
    int width;
    int height;
    SecureRandom secureRandom = new SecureRandom();

    public Board(int width, int height, int mines){
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                tiles[i][j] = new Tile(new Point(i, j));
            }
        }
        placeMines(mines);
        assignNumbers();
    }

    private void assignNumbers() {
        // go through all tiles and count adjacent mines
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.width; j++){
                int near = countNearMines(tiles[i][j]);
                tiles[i][j].setNearbyMines(near);
            }
        }
    }

    private int countNearMines(Tile tile) {
        // there are up to 8 near tiles
        // start with i-1 and j-i
        int count = 0;
        List<Tile> nears = getNeighbors(tile);
        for (Tile near : nears){
            if(near.isMine()){
                count++;
            }
        }
        return count;
    }

    private List<Tile> getNeighbors(Tile start) {
        List<Tile> neighbors = new ArrayList<>();
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                try {
                    neighbors.add(tiles[start.getPoint().x+i][start.getPoint().y+j]);
                }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
                    // ignore
                }
            }
        }
        return neighbors;
    }


    public void clickTile(Point point) {
        Tile tile = tiles[point.y][point.x];
        tile.setRevealed(true);
        if(tile.isMine()) {
            throw new RuntimeException("everything blew up");
        }
        if(tile.getNearbyMines() == 0){
            revealNeighbors(tile);
        }
    }

    public boolean won(){
        // every tile except mines are revealed
        for (int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                if(tiles[i][j].isRevealed() || tiles[i][j].isMine()){
                    // continue
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void revealNeighbors(Tile start) {
        // for each neighbor
        List<Tile> neighbors = getNeighbors(start);
        // if has mine near, reveal
        for(Tile tile : neighbors){
            if(tile.isRevealed()){
                continue;
            }
            tile.setRevealed(true);
            // if empty, reveal and reveal neighbors
            if(tile.getNearbyMines() == 0 && !tile.isMine() && !tile.equals(start)){
                revealNeighbors(tile);
            }
        }
    }

    private void placeMines(int mines) {
        // TODO non square board
        int tileCount = tiles[0].length * tiles[0].length;
        for (int i = 0; i < mines; i++) {
            // get random # between 0 and tile count
            while (true) {
                int index = randomIndex(tileCount);
                Tile tile = getTileByIndex(index);
                if (!tile.isMine()) {
                    tile.setMine(true);
                    break;
                }
            }
        }
    }

    private Tile getTileByIndex(int index) {
        int column = index % width;
        int row = index / width;
        return this.tiles[column][row];
    }

    private int randomIndex(int max) {
        return secureRandom.nextInt(max);
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                ", width=" + width +
                ", height=" + height +
                ", secureRandom=" + secureRandom +
                '}';
    }

    public String printBoard() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Tile tile = this.tiles[i][j];
                String s = " ? ";
                if (tile.isRevealed()) {
                    if(tile.isMine()) {
                        s = " m ";
                    } else if(tile.getNearbyMines() > 0){
                        s = " " + tile.getNearbyMines() + " ";
                    } else {
                        s = " _ ";
                    }
                }
                stringBuffer.append(s);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
