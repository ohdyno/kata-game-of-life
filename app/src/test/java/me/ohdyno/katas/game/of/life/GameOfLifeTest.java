package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest {
    @UseReporter(ClipboardReporter.class)
    @Test
    void gameOfLifeAdvancesToNextGridAndTheNewGridCanBeObserved() {
        Grid grid = new Grid(1,1);
        LifeObserverSpy observer = new LifeObserverSpy();
        GameOfLife game = new GameOfLife(observer);

        game.advance(grid);

        Approvals.verify(observer.observed());
    }

    private static class LifeObserverSpy implements LifeObserver {
        public Grid observed() {
            return null;
        }
    }
}
