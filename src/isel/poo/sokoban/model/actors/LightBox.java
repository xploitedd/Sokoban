package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;

public final class LightBox extends Box {

    public static final char TYPE = '#';

    public LightBox() { super(TYPE); }

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.hasActor() && to.getActor().getType() == TYPE) {
            Cell other = level.getCell(to.line + dir.dl, to.column + dir.dc);
            if (!super.move(level, dir, to, other))
                return false;
        }

        return super.move(level, dir, from, to);
    }

}
