package isel.poo.sokoban.model;

import isel.poo.sokoban.model.actors.*;
import isel.poo.sokoban.model.cells.Cell;
import isel.poo.sokoban.model.cells.FloorCell;
import isel.poo.sokoban.model.cells.HoleCell;
import isel.poo.sokoban.model.cells.ObjectiveCell;

public class Level {

    private final int levelNumber;
    private final int height;
    private final int width;

    private Game game;
    private Cell[] playersCell;
    private Cell[][] board;
    private Observer observer;
    private int players = 0;
    private int moves;
    private int boxes;
    private boolean manIsDead;

    /**
     * Constructor for each level
     * @param levelNumber Level number
     * @param height Height of the level
     * @param width Width of the level
     */
    Level(int levelNumber, int height, int width, int maxPlayers) {
        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;

        board = new Cell[height][width];
        playersCell = new Cell[maxPlayers];
    }

    /**
     * Inits the current level with the game
     * @param game Game
     */
    public void init(Game game) {
        this.game = game;
    }

    /**
     * Resets the current level
     */
    public void reset() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++)
                board[j][i] = null;
        }

        for (int i = 0; i < players; i++)
            playersCell[i] = null;

        players = 0;
        moves = 0;
        boxes = 0;
        manIsDead = false;
    }

    /**
     * Puts a box or an actor on the given position
     * @param l Line
     * @param c Column
     * @param type Type of the box/actor
     */
    public void put(int l, int c, char type) {
        Cell cell = Cell.getCellByType(l, c, type);
        // if the cell == null then the type corresponds to an actor
        if (cell == null) {
            cell = board[l][c];
            if (cell == null) {
                cell = new FloorCell(l, c);
                board[l][c] = cell;
            }

            Actor actor = null;
            switch (type) {
                case Player.TYPE:
                    actor = new Player(players);
                    playersCell[players++] = cell;
                    break;
                case Box.TYPE:
                    actor = new Box();
                    addBox(cell);
                    break;
                case LightBox.TYPE:
                    actor = new LightBox();
                    addBox(cell);
                    break;
                case Key.TYPE:
                    actor = new Key();
                    break;
            }

            cell.setActor(actor);
            return;
        }

        if (board[l][c] == null)
            board[l][c] = cell;
    }

    /**
     * Increases the box count if the cell isn't already an objective
     * @param cell Cell to check
     */
    private void addBox(Cell cell) {
        if (cell.getType() != ObjectiveCell.TYPE)
            ++boxes;
    }

    /**
     * Moves the man in the given direction
     * @param dir Direction to move
     */
    public void moveMan(Dir dir, int playerId) {
        if (playerId >= players)
            return;

        Cell playerCell = playersCell[playerId];
        int l = playerCell.line, c = playerCell.column;
        int nextL = l + dir.dl;
        int nextC = c + dir.dc;

        Cell nextCell = getCell(nextL, nextC);
        if (nextCell == null)
            return;

        Player player = (Player) playerCell.getActor();
        if (player.move(this, dir, playerCell, nextCell)) {
            playersCell[playerId] = nextCell;
            ++moves;
            manIsDead = nextCell.getType() == HoleCell.TYPE;
            if (manIsDead)
                observer.onPlayerDead(player);
            else
                observer.onPlayerMove(player);
        }
    }

    /**
     * Updates the cell
     * @param cell Cell to be updated
     */
    public void updateCell(Cell cell) { observer.onCellUpdated(cell); }

    /**
     * Replaces a cell by another one
     * @param replaced Cell to be replaced
     * @param replace Cell to replace
     */
    public void replaceCell(Cell replaced, Cell replace) {
        int l = replaced.line, c = replaced.column;
        board[l][c] = replace;
        observer.onCellReplaced(l, c, replace);
    }

    /**
     * Called when a box is moved by another actor
     * @param box Box that is moved
     */
    public void boxMoved(Box box) { observer.onBoxMove(box); }

    /**
     * Updates the remaining boxes for this level
     * @param delta Increment/Decrement for the box count
     */
    public void incrementBoxCount(int delta) { boxes += delta; }

    /**
     * Sets an observer for this level
     * @param observer Observer
     */
    public void setObserver(Observer observer) { this.observer = observer; }

    /**
     * Checks if the player won the level or got killed
     * @return True if the player won or got killed, false otherwise
     */
    public boolean isFinished() { return boxes == 0 || manIsDead; }

    /**
     * Checks if the player is dead
     * @return True if dead, false otherwise
     */
    public boolean manIsDead() { return manIsDead; }

    /**
     * Gets the current level number
     * @return Level number
     */
    public int getNumber() { return levelNumber; }

    /**
     * Gets the current level width
     * @return Level width
     */
    public int getWidth() { return width; }

    /**
     * Gets the current level height
     * @return Level height
     */
    public int getHeight() { return height; }

    /**
     * Gets the remaining boxes to end this level
     * @return Remaining boxes
     */
    public int getRemainingBoxes() { return boxes; }

    /**
     * Gets how many time the player has moved
     * @return Moves
     */
    public int getMoves() { return moves; }

    /**
     * Gets the cell based on the line and column
     * @param l Line
     * @param c Column
     * @return Cell that is on line l and column c, null if there is none
     */
    public Cell getCell(int l, int c) {
        /* Protects against NullPointerException
         * verifying if the line position is within the
         * width of the board.
         * There's no need to do the same for the column
         * because if the column is not null and the line
         * is null it returns null in the end.
        */
        if (l >= width || l < 0)
            return null;

        return board[l][c];
    }

    public interface Observer {

        /**
         * Called when a cell gets updated
         * e.g an actor moves into it
         * @param cell Cell that is updated
         */
        void onCellUpdated(Cell cell);

        /**
         * Called when a cell gets replaced
         * e.g a box moves into a hole and the cell transforms into Floor
         * @param l Line where the current cell is
         * @param c Column where the current cell is
         * @param cell Replace cell
         */
        void onCellReplaced(int l, int c, Cell cell);

        /**
         * Called when a player gets killed
         * @param player Player that was killed
         */
        void onPlayerDead(Player player);

        /**
         * Called when a player is moved
         * @param player Player that was moved
         */
        void onPlayerMove(Player player);

        /**
         * Called when a box is moved
         * @param box Box that was moved
         */
        void onBoxMove(Box box);

    }

}
