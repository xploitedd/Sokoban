package isel.poo.sokoban.view.tiles.directional;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;
import isel.poo.sokoban.view.tiles.FloorCellTile;

public abstract class DirectionalCellTile extends FloorCellTile {

    private final char direction;

    DirectionalCellTile(Cell cell, char direction) {
        super(cell);
        this.direction = direction;
    }

    @Override
    public void clear() {
        super.clear();
        printChar(direction, Console.RED);
    }

}
