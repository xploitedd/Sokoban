package isel.poo.sokoban.model.cells;

public final class ObjectiveCell extends FloorCell {

    public static final char TYPE = '*';

    public ObjectiveCell(int l, int c) {
        super(l, c, TYPE);
    }

}
