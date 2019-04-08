package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.actors.Actor;
import isel.poo.sokoban.model.cells.directional.DownCell;
import isel.poo.sokoban.model.cells.directional.UpCell;

public abstract class Cell {

    public final int line;
    public final int column;

    protected Actor actor;

    public Cell(int l, int c) {
        line = l;
        column = c;
    }

    public boolean moveActorToCell(Dir dir, Actor actor) { return false; }

    public final void setActor(Actor actor) { this.actor = actor; }

    public final Actor getActor() { return actor; }

    public final boolean hasActor() { return actor != null; }

    public abstract char getType();

    public static Cell getCellByType(int l, int c, char type) {
        switch (type) {
            case FloorCell.TYPE:
                return new FloorCell(l, c);
            case WallCell.TYPE:
                return new WallCell(l, c);
            case ObjectiveCell.TYPE:
                return new ObjectiveCell(l, c);
            case HoleCell.TYPE:
                return new HoleCell(l, c);
            case EmptyCell.TYPE:
                return new EmptyCell(l, c);
            case UpCell.TYPE:
                return new UpCell(l, c);
            case DownCell.TYPE:
                return new DownCell(l, c);
            default:
                return null;
        }
    }

}
