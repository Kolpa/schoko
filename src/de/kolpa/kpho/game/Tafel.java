package de.kolpa.kpho.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolpa on 06.04.2017.
 */
public class Tafel {
    public class InvalidBoardSizeException extends Throwable {

    }

    public class BoardTooSmallException extends Throwable {}

    private List<List<Stueck>> board;

    private List<Stueck> makeFirstRow(int width) {
        List<Stueck> row = new ArrayList<>();

        row.add(Stueck.SEIFE);

        for (int i = 1; i < width; i++) {
            row.add(Stueck.SCHOKOLADE);
        }

        return row;
    }

    private List<Stueck> makeNormalRow(int width) {
        List<Stueck> row = new ArrayList<>();

        for (int i = 1; i <= width; i++) {
            row.add(Stueck.SCHOKOLADE);
        }

        return row;
    }

    private List<List<Stueck>> makeBoard(int width, int height) throws InvalidBoardSizeException {
        if (width < 1 || height < 1)
            throw new InvalidBoardSizeException();

        List<List<Stueck>> rows = new ArrayList<>();

        List<Stueck> row = makeFirstRow(width);

        rows.add(row);

        for (int r = 1; r < height; r++) {
            rows.add(makeNormalRow(width));
        }

        return rows;
    }

    Tafel(int width, int height) throws InvalidBoardSizeException {
        board = makeBoard(width, height);
    }

    public boolean isOver() {
        if (board.size() == 1 && board.get(0).size() == 1)
            return true;

        if (board.size() < 1)
            return true;

        return board.size() >= 1 && board.get(0).size() < 1;
    }

    public void removeRows(int amount) throws BoardTooSmallException {
        if (amount <= 0)
            throw new BoardTooSmallException();

        if (amount > board.size() - 1)
            throw new BoardTooSmallException();

        for (; amount > 0; amount--) {
            int i = board.size() - 1;
            board.remove(i);
        }
    }

    public void removeCols(int amount) throws BoardTooSmallException {
        if (amount <= 0)
            throw new BoardTooSmallException();

        if (amount > board.get(0).size() - 1)
            throw new BoardTooSmallException();

        for (; amount > 0; amount--) {
            int i = board.get(0).size() - 1;

            for (int ix = 0; ix < board.size(); ix++)
                board.get(ix).remove(i);
        }
    }

    public int getWidth() {
        return board.get(0).size();
    }

    public int getHeight() {
        return board.size();
    }

    private List<List<Stueck>> deepCopy(List<List<Stueck>> in) {
        List<List<Stueck>> out = new ArrayList<>();

        for (List<Stueck> inl : in) {
            out.add(new ArrayList<>(inl));
        }

        return out;
    }

    public boolean canRemoveRows(int amount) {
        List<List<Stueck>> old = deepCopy(board);

        try {
            removeRows(amount);
        } catch (BoardTooSmallException e) {
            board = old;
            return false;
        }

        boolean over = isOver();

        board = old;

        return !over;
    }

    public boolean canRemoveCols(int amount) {
        List<List<Stueck>> old = deepCopy(board);

        try {
            removeCols(amount);
        } catch (BoardTooSmallException e) {
            board = old;
            return false;
        }

        boolean over = isOver();

        board = old;

        return !over;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for(List<Stueck> row : board) {

            for (Stueck stueck : row) {
                out.append(stueck);
                out.append(" ");
            }

            out.setLength(out.length() - 1);

            out.append("\n");
        }

        out.setLength(out.length() - 1);

        return out.toString();
    }
}
