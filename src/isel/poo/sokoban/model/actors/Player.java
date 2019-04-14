package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;

public final class Player extends Actor {

    public static final char TYPE = '@';

    public final int playerId;

    /**
     * Constructor for the player actor
     * @param playerId playerId of this player
     */
    public Player(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.hasActor()) {
            Actor toActor = to.getActor();
            if (toActor.getType() == Player.TYPE)
                return false;

            Cell other = level.getCell(to.line + dir.dl, to.column + dir.dc);
            if (!toActor.move(level, dir, to, other))
                return false;
        }

        return super.move(level, dir, from, to);
    }

    @Override
    public char getType() {
        return TYPE;
    }

}
