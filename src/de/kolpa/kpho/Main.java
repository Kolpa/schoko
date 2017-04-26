package de.kolpa.kpho;

import de.kolpa.kpho.game.Game;
import de.kolpa.kpho.game.Tafel;

/**
 * Created by Kolpa on 11.04.2017 use at own risk might be horribly broken...
 */
public class Main {

    public static void main(String args[]) {
        try {
            Game game = new Game();

            while (!game.isOver()) {
                game.printBoard();

                game.doTurn();
            }

            game.printBoard();

            System.out.println("Spieler " + game.currentPlayer() + " hat verloren");
        } catch (Tafel.InvalidBoardSizeException e) {
            e.printStackTrace();
        }
    }
}
