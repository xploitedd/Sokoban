package isel.poo.sokoban.view.tiles;

import isel.leic.pg.Console;
import isel.poo.sokoban.model.actors.*;
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
                int playerId = ((Player) actor).playerId + '1';
                printChar((char) playerId, Console.BLACK);
            } else if (actor instanceof LightBox) {
                setLightBoxBackground();
                printChar('#', Console.BLACK);
            } else if (actor instanceof Box) {
                setBoxBackground();
                printChar('o', Console.BLACK);
            } else if (actor instanceof Key) {
                setKeyBackground();
                printChar('⚷', Console.YELLOW);
            }
        }
    }

    /**
     * Sets the player background color
     */
    protected void setPlayerBackground() { Console.setBackground(Console.YELLOW); }

    /**
     * Sets the box background color
     */
    protected void setBoxBackground() { Console.setBackground(Console.RED); }

    /**
     * Sets the LightBox background color
     */
    protected void setLightBoxBackground() { Console.setBackground(Console.BLUE); }

    /**
     * Sets the LightBox background color
     */
    protected void setKeyBackground() { Console.setBackground(Console.WHITE); }

}
