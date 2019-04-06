package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.cells.PlayableCell;

public abstract class DirectionalCell extends PlayableCell {

    public DirectionalCell(int l, int c) {
        super(l, c);
    }

    public abstract Dir getDirection();

    public boolean canMoveForward(Dir fromDir) { return getDirection() == fromDir; }

}
