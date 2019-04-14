package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class EmptyCellTile extends CellTile {

    EmptyCellTile(Cell cell) { super(cell, Console.BLACK); }

}
