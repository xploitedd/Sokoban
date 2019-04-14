package isel.poo.sokoban.model.cells;

public class DoorCell extends Cell {
    public static final char TYPE = 'P';

    public DoorCell(int l, int c) {
        super(l, c);
    }

    @Override
    public char getType() {
        return TYPE;
    }
}