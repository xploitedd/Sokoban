package isel.poo.sokoban.model.actors;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.Level;
import isel.poo.sokoban.model.cells.Cell;
import isel.poo.sokoban.model.cells.directional.DirectionalCell;
import isel.poo.sokoban.model.cells.directional.DownCell;
import isel.poo.sokoban.model.cells.directional.UpCell;

public abstract class Actor {

    public boolean move(Level level, Dir dir, Cell from, Cell to) {
        if (to.getType() == UpCell.TYPE || to.getType() == DownCell.TYPE) {
            DirectionalCell directionalCell = (DirectionalCell) to;
            if (!directionalCell.canMoveForward(dir))
                return false;
        }

        if (to.setActor(from.getActor())) {
            from.setActor(null);
            level.updateCell(from);
            level.updateCell(to);
            return true;
        }

        return false;
    }

    public abstract char getType();

}
