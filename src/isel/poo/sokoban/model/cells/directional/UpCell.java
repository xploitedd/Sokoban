package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;

public final class UpCell extends DirectionalCell {

    public static final char TYPE = 'U';
    public static final Dir DIRECTION = Dir.UP;

    public UpCell(int l, int c) {
        super(l, c, TYPE, DIRECTION);
    }

}
