package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;

public final class LeftCell extends DirectionalCell {

    public static final char TYPE = 'L';
    public static final Dir DIRECTION = Dir.LEFT;

    public LeftCell(int l, int c) {
        super(l, c);
    }

    @Override
    public Dir getDirection() {
        return DIRECTION;
    }

    @Override
    public char getType() { return TYPE; }

}
