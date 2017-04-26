package de.kolpa.kpho.player;

import de.kolpa.kpho.game.Tafel;

import java.util.Random;

/**
 * Created by Kolpa on 11.04.2017 use at own risk might be horribly broken...
 */
public class AI implements Player {
    private  Random rand;

    public AI() {
        rand = new Random(System.currentTimeMillis());
    }

    @Override
    public void doTurn(Tafel board) {
        try {
            if (board.getHeight() > board.getWidth()) {
                int diff = board.getHeight() - board.getWidth();
                board.removeRows(diff);
                System.out.println("Ich entferne " + diff + " Reihe/n");

            } else if (board.getHeight() == board.getWidth()) {

                if (rand.nextBoolean()) {
                    board.removeRows(1);
                    System.out.println("Ich entferne 1 Reihe/n");
                } else {
                    board.removeCols(1);
                    System.out.println("Ich entferne 1 Spalte/n");
                }

            } else {
                int diff = board.getWidth() - board.getHeight();
                board.removeCols(diff);
                System.out.println("Ich entferne " + diff + " Spalte/n");
            }
        } catch (Tafel.BoardTooSmallException e) {
            e.printStackTrace();
        }
    }
}
