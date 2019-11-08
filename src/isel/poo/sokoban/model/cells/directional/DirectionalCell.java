package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.actors.Actor;
import isel.poo.sokoban.model.cells.FloorCell;
import isel.poo.sokoban.model.cells.PlayableCell;

public abstract class DirectionalCell extends PlayableCell {

    DirectionalCell(int l, int c) {
        super(l, c);
    }

    /**
     * Returns which direction an actor can move
     * @return allowed direction
     */
    public abstract Dir getDirection();

    @Override
    public boolean canHaveActor(Dir dir, Actor actor) {
        if (dir != getDirection())
            return false;

        return super.canHaveActor(dir, actor);
    }

}
