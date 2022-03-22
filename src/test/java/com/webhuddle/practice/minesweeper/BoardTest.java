package com.webhuddle.practice.minesweeper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testBoardMines() {
        Board board = new Board(10, 10, 3);
        Assertions.assertEquals(3, countMines(board));
        board.clickTile(new Point(2, 1));
        System.out.println(board.printBoard());
    }

    @Test
    void testBoardMinesTwenty() {
        Board board = new Board(10, 10, 20);
        Assertions.assertEquals(20, countMines(board));
        board.clickTile(new Point(2, 1));
        System.out.println(board.printBoard());
    }

    @Test
    void testBoardMinesTen() {
        Board board = new Board(10, 10, 10);
        Assertions.assertEquals(10, countMines(board));
        board.clickTile(new Point(2, 1));
        System.out.println(board.printBoard());
    }

    @Test
    void testBoardMinesNone() {
        Board board = new Board(10, 10, 0);
        Assertions.assertEquals(0, countMines(board));
        System.out.println(board.printBoard());
        board.clickTile(new Point(2, 1));
        System.out.println(board.printBoard());
    }

    @Test
    void testBoardMinesAll() {
        Board board = new Board(10, 10, 100);
        Assertions.assertEquals(100, countMines(board));
        System.out.println(board.printBoard());
    }

    @Test
    void testPrintBoard() {
        Board board = new Board(10, 10, 100);
        System.out.println(board.printBoard());
        board.clickTile(new Point(2, 1));
        System.out.println(board.printBoard());
    }

    private int countMines(Board board) {
        int mines = 0;
        for (int i = 0; i < board.width; i++) {
            for (int j = 0; j < board.height; j++) {
                if(board.tiles[i][j].isMine()){
                    mines++;
                }
            }
        }
        return mines;
    }

}