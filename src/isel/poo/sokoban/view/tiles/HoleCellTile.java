package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.cells.Cell;

public final class HoleCellTile extends PlayableCellTile {

    HoleCellTile(Cell cell) {
        super(cell, Console.CYAN);
    }

    @Override
    public void clear() {
        super.clear();
        printChar('~', Console.GRAY);
    }

    @Override
    protected void setPlayerBackground() {
        Console.setBackground(Console.GRAY);
    }
}
