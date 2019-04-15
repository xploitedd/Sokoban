package isel.poo.sokoban.model.cells.directional;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.actors.Actor;
import isel.poo.sokoban.model.cells.FloorCell;

public abstract class DirectionalCell extends FloorCell {

    private Dir direction;

    DirectionalCell(int l, int c, char type, Dir direction) {
        super(l, c, type);
        this.direction = direction;
    }

    /**
     * Returns which direction an actor can move
     * @return allowed direction
     */
    public final Dir getDirection() { return direction; }

    @Override
    public boolean canHaveActor(Dir dir, Actor actor) {
        if (dir != direction)
            return false;

        return super.canHaveActor(dir, actor);
    }

}
