package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;
import isel.poo.sokoban.model.cells.DoorCell;
import isel.poo.sokoban.model.cells.FloorCell;

public final class Key extends Actor {

    public static final char TYPE = 'K';

    public Key() {
        super(TYPE);
    }

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.hasActor())
            return false;

        if (super.move(level, dir, from, to)) {
            if (to.getType() == DoorCell.TYPE)
                level.replaceCell(to, new FloorCell(to.line, to.column));

            return true;
        }

        return false;
    }

}
