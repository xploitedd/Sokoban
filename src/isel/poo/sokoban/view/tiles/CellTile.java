package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;
import isel.poo.sokoban.model.cells.*;
import isel.poo.sokoban.model.cells.directional.DownCell;
import isel.poo.sokoban.model.cells.directional.UpCell;

public abstract class CellTile extends Tile {

    public static int SIDE = 2;

    private final int tileColor;
    protected final Cell cell;

    /**
     * Constructor of CellTile
     * @param cell Cell that corresponds to this tile
     * @param tileColor Background color of this tile
     */
    CellTile(Cell cell, int tileColor) {
        this.cell = cell;
        this.tileColor = tileColor;
    }

    @Override
    protected void init() {
        setBackground(tileColor);
    }

    /**
     * Prints a char to the tile
     * @param p char to be printed
     * @param foregroundColor foreground color of the char
     */
    protected void printChar(char p, int foregroundColor) {
        Console.setForeground(foregroundColor);
        for (int c = 0; c < SIDE; ++c) {
            for (int l = 0; l < SIDE; ++l)
                print(l, c, p);
        }
    }

    /**
     * Transforms a cell object into a cell tile
     * @param cell Cell to be transformed
     * @return corresponding CellTile
     */
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
        else if (cell instanceof DoorCell)
            return new DoorCellTile(cell);
        else
            return new EmptyCellTile(cell);
    }

}
