package de.kolpa.kpho.game;

/**
 * Created by Kolpa on 06.04.2017.
 */
enum Stueck {
    SEIFE, SCHOKOLADE;

    @Override
    public String toString() {
        switch (this) {
            case SCHOKOLADE:
                return "O";
            default:
                return "X";
        }
    }
}
