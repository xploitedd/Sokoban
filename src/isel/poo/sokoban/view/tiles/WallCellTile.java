package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class WallCellTile extends CellTile {

    WallCellTile(Cell cell) {
        super(cell, Console.BROWN);
    }

    @Override
    public void paint() {
        printChar('-', Console.BLACK);
    }
}
