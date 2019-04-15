package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;

public final class DownCell extends DirectionalCell {

    public static final char TYPE = 'D';
    public static final Dir DIRECTION = Dir.DOWN;

    public DownCell(int l, int c) {
        super(l, c, TYPE, DIRECTION);
    }

}
