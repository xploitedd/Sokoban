package isel.poo.sokoban.model;

public enum Dir {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    public final int dc;
    public final int dl;

    Dir(int dc, int dl) {
        this.dc = dc;
        this.dl = dl;
    }

}
