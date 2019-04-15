package isel.poo.sokoban.model.cells;

public final class HoleCell extends PlayableCell {

    public static final char TYPE = 'H';

    public HoleCell(int l, int c) {
        super(l, c, TYPE);
    }

}
