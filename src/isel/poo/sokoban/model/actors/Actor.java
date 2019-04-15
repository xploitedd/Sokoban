package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;

public abstract class Actor {

    private final char type;

    Actor(char type) {
        this.type = type;
    }

    /**
     * Moves the actor into a desired cell
     * @param level Level where the actor will be moved
     * @param dir Direction to move the actor
     * @param from Where the actor is currently
     * @param to Where the actor will go
     * @return true if the actor moves, false otherwise
     */
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        Actor actor = from.getActor();
        if (to.canHaveActor(dir, actor)) {
            to.setActor(actor);
            from.setActor(null);

            level.updateCell(from);
            level.updateCell(to);

            return true;
        }

        return false;
    }

    /**
     * Gets the actor type
     * @return actor type
     */
    public final char getType() { return type; }

}
