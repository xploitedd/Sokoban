package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.actors.Actor;
import isel.poo.sokoban.model.cells.PlayableCell;

public abstract class DirectionalCell extends PlayableCell {

    public DirectionalCell(int l, int c) {
        super(l, c);
    }

    public abstract Dir getDirection();

    @Override
    public boolean moveActorToCell(Dir dir, Actor actor) {
        if (dir != getDirection())
            return false;

        return super.moveActorToCell(dir, actor);
    }
}
