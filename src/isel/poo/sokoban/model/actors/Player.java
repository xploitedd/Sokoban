package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;

public final class Player extends Actor {

    public static final char TYPE = '@';

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        Actor toActor = to.getActor();
        if (toActor != null) {
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
