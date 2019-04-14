package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.*;

public class Key extends Actor {
    public static final char TYPE = 'K';

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.getActor() != null)
            return false;

        if (super.move(level, dir, from, to)) {
            if (to.getType() == DoorCell.TYPE) {
                level.replaceCell(to, new FloorCell(to.line, to.column));
            }
            return true;
        }

        return false;
    }

    @Override
    public char getType() {
        return TYPE;
    }
}