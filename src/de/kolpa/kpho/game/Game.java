package de.kolpa.kpho.game;

import de.kolpa.kpho.player.AI;
import de.kolpa.kpho.player.Human;
import de.kolpa.kpho.player.Player;

import java.util.Scanner;

import static de.kolpa.kpho.Util.inputBoolFromUser;

public class Game {
    private Tafel board;
    private Player[] players;
    private int active = 0;

    public Game() throws Tafel.InvalidBoardSizeException {
        Scanner input = new Scanner(System.in);

        buildBoard(input);
        makePlayers(input);
    }

    private void makePlayers(Scanner input) {


        System.out.print("How many Players: ");
        int max = input.nextInt();

        players = new Player[max];

        for (int pid = 0; pid < max; pid++) {
            if (inputBoolFromUser("is player " + (pid + 1) + " human: ", input))
                players[pid] = new Human();
            else
                players[pid] = new AI();
        }
    }

    private void buildBoard(Scanner input) throws Tafel.InvalidBoardSizeException {
        System.out.print("Board width: ");
        int width = input.nextInt();

        System.out.print("Board height: ");
        int height = input.nextInt();

        board = new Tafel(width, height);
    }

    public void doTurn() {
        System.out.println("Spieler " + (active + 1) + " ist dran");

        players[active].doTurn(board);

        active += 1;

        if (active >= players.length)
            active = 0;
    }

    public int currentPlayer() {
        return active + 1;
    }

    public boolean isOver() {
        return board.isOver();
    }

    public void printBoard() {
        System.out.println("\n" + board.toString() + "\n\n");
    }
}
