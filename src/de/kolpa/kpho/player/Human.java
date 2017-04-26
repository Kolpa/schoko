package de.kolpa.kpho.player;

import de.kolpa.kpho.game.Tafel;

import java.util.Scanner;

import static de.kolpa.kpho.Util.inputRowFromUser;

public class Human implements Player {

    @Override
    public void doTurn(Tafel board) {
        Scanner input = new Scanner(System.in);

        if (inputRowFromUser("Reihen oder Spalten[R/S]: ", input)) {
            //Rows
            boolean done = false;

            while (!done) {
                System.out.print("Wie viele: ");
                int rows = input.nextInt();

                try {
                    board.removeRows(rows);
                    done = true;
                } catch (Tafel.BoardTooSmallException e) {
                    System.out.println("Das sind zu viele5");
                }
            }
        } else {
            //Cols
            boolean done = false;

            while (!done) {
                System.out.print("Wie viele: ");
                int rows = input.nextInt();

                try {
                    board.removeCols(rows);
                    done = true;
                } catch (Tafel.BoardTooSmallException e) {
                    System.out.println("Das sind zu viele");
                }
            }
        }
    }
}
