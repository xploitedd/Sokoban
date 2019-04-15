package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public class FloorCellTile extends PlayableCellTile {

    public FloorCellTile(Cell cell) {
        super(cell, Console.WHITE);
    }

}
