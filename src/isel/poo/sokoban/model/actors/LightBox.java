package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;

public final class LightBox extends Box {

    public static final char TYPE = '#';

    public boolean move(Level level, Dir dir, Cell from, Cell to, boolean nonFirst) {
        if (nonFirst)
            return super.move(level, dir, from, to);

        return move(level, dir, from, to);
    }

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        Actor toActor = to.getActor();
        if (toActor != null && toActor.getType() == TYPE) {
            LightBox lightBox = (LightBox) toActor;
            Cell other = level.getCell(to.line + dir.dl, to.column + dir.dc);
            if (!lightBox.move(level, dir, to, other, true))
                return false;
        }

        return super.move(level, dir, from, to);
    }

    @Override
    public char getType() {
        return TYPE;
    }

}
