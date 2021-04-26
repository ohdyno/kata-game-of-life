package me.ohdyno.katas.game.of.life;

public class GameOfLife {
    private final LifeObserver observer;

    public GameOfLife(LifeObserver observer) {
        this.observer = observer;
    }

    void advance(Grid grid) {
        observer.observed(grid.advance());
    }
}
