package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;
import isel.poo.sokoban.model.cells.FloorCell;
import isel.poo.sokoban.model.cells.HoleCell;
import isel.poo.sokoban.model.cells.ObjectiveCell;

public class Box extends Actor {

    public static final char TYPE = 'B';

    @Override
    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.getActor() != null)
            return false;

        if (super.move(level, dir, from, to)) {
            int boxCount = level.getRemainingBoxes();
            if (to.getType() == ObjectiveCell.TYPE) {
                if (from.getType() != ObjectiveCell.TYPE)
                    level.updateBoxCount(--boxCount);
            } else if (to.getType() == HoleCell.TYPE) {
                level.replaceCell(to, new FloorCell(to.line, to.column));
            } else if (from.getType() == ObjectiveCell.TYPE)
                level.updateBoxCount(++boxCount);

            return true;
        }

        return false;
    }

    @Override
    public char getType() {
        return TYPE;
    }

}
