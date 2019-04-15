package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class LeftCellTile extends FloorCellTile {

    LeftCellTile(Cell cell) {
        super(cell);
    }

    @Override
    public void clear() {
        super.clear();
        printChar('˂', Console.RED);
    }

}
