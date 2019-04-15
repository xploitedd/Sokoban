package isel.poo.sokoban.model.cells;

public final class EmptyCell extends Cell {

    public static final char TYPE = '.';

    public EmptyCell(int l, int c) {
        super(l, c, TYPE);
    }

}
