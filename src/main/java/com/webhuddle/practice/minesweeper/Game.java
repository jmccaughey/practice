package com.webhuddle.practice.minesweeper;

import java.awt.*;
import java.util.Scanner;

public class Game {

    public static void main(String[] args){
        Board board = new Board(10, 10, 8);
        System.out.println(board.printBoard());
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter x");
            int x = scanner.nextInt();
            System.out.println("enter y");
            int y = scanner.nextInt();
            board.clickTile(new Point(x, y));
            System.out.println(board.printBoard());
        }while(!board.won());
        System.out.println("you won!");
    }

}
