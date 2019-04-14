package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public class DoorCellTile extends CellTile {
    DoorCellTile(Cell cell) {
        super(cell, Console.BROWN);
    }

    @Override
    public void paint() {
        printChar('█', Console.RED);
    }
}
