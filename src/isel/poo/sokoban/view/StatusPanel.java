package isel.poo.sokoban.view;

import isel.leic.pg.Console;
import isel.poo.console.FieldView;
import isel.poo.console.ParentView;

public class StatusPanel extends ParentView {

    public static final int WIDTH = 7;

    private final FieldView level = new FieldView("Level", 1, 1, "1");
    private final FieldView moves = new FieldView("Moves", 4, 1, "0");
    private final FieldView boxes = new FieldView("Boxes", 7, 1, "0");

    /**
     * Creates the status panel with game information
     * @param width Game window width
     * @param height Game window height
     */
    public StatusPanel(int width, int height) {
        super(0, width, height, WIDTH, Console.DARK_GRAY);

        addView(level);
        addView(moves);
        addView(boxes);
    }

    /**
     * Sets the new level on the FieldView
     * @param level Level to be displayed
     */
    public void setLevel(int level) {
        this.level.setValue(level);
    }

    /**
     * Sets the amount of moves on the FieldView
     * @param moves Moves to be displayed
     */
    public void setMoves(int moves) {
        this.moves.setValue(moves);
    }

    /**
     * Sets the amount of boxes on the FieldView
     * @param boxes Boxes to be displayed
     */
    public void setBoxes(int boxes) {
        this.boxes.setValue(boxes);
    }

    @Override
    public void paint() {
        super.paint();

        Console.color(Console.YELLOW, bkColor);
        print(10, 0, "Cursor");
        print(12, 0, "Esc");
        print(14, 0, "S");
        Console.color(Console.WHITE, bkColor);
        print(11, 1, "move");
        print(13, 1, "finish");
        print(15, 1, "start");
    }
}
