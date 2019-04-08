package isel.poo.sokoban.model.cells;

import isel.poo.sokoban.model.Dir;
import isel.poo.sokoban.model.actors.Actor;

public abstract class PlayableCell extends Cell {

    public PlayableCell(int l, int c) {
        super(l, c);
    }

    @Override
    public boolean moveActorToCell(Dir dir, Actor actor) {
        this.actor = actor;
        return true;
    }
}
