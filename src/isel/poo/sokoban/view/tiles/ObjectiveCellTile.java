package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class ObjectiveCellTile extends FloorCellTile {

    ObjectiveCellTile(Cell cell) {
        super(cell);
    }

    @Override
    public void clear() {
        super.clear();
        printChar('+', Console.GREEN);
    }

    @Override
    protected void setBoxBackground() {
        Console.setBackground(Console.GREEN);
    }

    @Override
    protected void setLightBoxBackground() {
        Console.setBackground(Console.GREEN);
    }
}
