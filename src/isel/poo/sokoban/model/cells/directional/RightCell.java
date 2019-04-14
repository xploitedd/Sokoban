package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;

public final class RightCell extends DirectionalCell {

    public static final char TYPE = 'R';
    public static final Dir DIRECTION = Dir.RIGHT;

    public RightCell(int l, int c) {
        super(l, c);
    }

    @Override
    public Dir getDirection() {
        return DIRECTION;
    }

    @Override
    public char getType() {
        return TYPE;
    }

}
