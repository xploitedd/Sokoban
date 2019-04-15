package isel.poo.sokoban.model.cells;

public final class WallCell extends Cell {

    public static final char TYPE = 'X';

    public WallCell(int l, int c) {
        super(l, c, TYPE);
    }

}
