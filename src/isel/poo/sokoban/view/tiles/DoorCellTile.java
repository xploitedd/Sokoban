package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class DoorCellTile extends PlayableCellTile {

    DoorCellTile(Cell cell) {
        super(cell, Console.BROWN);
    }

    @Override
    public void clear() {
        super.clear();
        printChar('█', Console.RED);
    }

}
