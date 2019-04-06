package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.cells.*;
import isel.poo.sokoban.model.cells.directional.DownCell;
import isel.poo.sokoban.model.cells.directional.UpCell;

public abstract class CellTile extends Tile {

    public static final int SIDE = 2;

    private final int tileColor;
    protected final Cell cell;

    CellTile(Cell cell, int tileColor) {
        this.cell = cell;
        this.tileColor = tileColor;
    }

    @Override
    protected void init() {
        setBackground(tileColor);
    }

    protected void printChar(char p, int foregroundColor) {
        Console.setForeground(foregroundColor);
        for (int c = 0; c < SIDE; ++c) {
            for (int l = 0; l < SIDE; ++l)
                print(l, c, p);
        }
    }

    public static CellTile tileOf(Cell cell) {
        if (cell instanceof FloorCell)
            return new FloorCellTile(cell);
        else if (cell instanceof HoleCell)
            return new HoleCellTile(cell);
        else if (cell instanceof ObjectiveCell)
            return new ObjectiveCellTile(cell);
        else if (cell instanceof WallCell)
            return new WallCellTile(cell);
        else if (cell instanceof UpCell)
            return new UpCellTile(cell);
        else if (cell instanceof DownCell)
            return new DownCellTile(cell);
        else
            return new EmptyCellTile(cell);
    }

}
