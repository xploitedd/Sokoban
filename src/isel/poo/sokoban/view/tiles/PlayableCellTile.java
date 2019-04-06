package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.actors.Actor;
import isel.poo.sokoban.model.actors.Box;
import isel.poo.sokoban.model.actors.LightBox;
import isel.poo.sokoban.model.actors.Player;
import isel.poo.sokoban.model.cells.Cell;

public abstract class PlayableCellTile extends CellTile {

    PlayableCellTile(Cell cell, int tileColor) {
        super(cell, tileColor);
    }

    @Override
    public void paint() {
        if (cell.hasActor()) {
            Actor actor = cell.getActor();
            if (actor instanceof Player) {
                setPlayerBackground();
                printChar('@', Console.BLACK);
            } else if (actor instanceof LightBox) {
                setLightBoxBackground();
                printChar('#', Console.BLACK);
            } else if (actor instanceof Box) {
                setBoxBackground();
                printChar('o', Console.BLACK);
            }
        }
    }

    protected void setPlayerBackground() { Console.setBackground(Console.YELLOW); }

    protected void setBoxBackground() { Console.setBackground(Console.RED); }

    protected void setLightBoxBackground() { Console.setBackground(Console.BLUE); }

}
