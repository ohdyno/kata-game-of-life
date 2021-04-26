package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest {
    @UseReporter({ClipboardReporter.class, FileMergeReporter.class})
    @Test
    void gameOfLifeAdvancesToNextGridAndTheNewGridCanBeObserved() {
        Grid grid = buildBlinkerGrid();
        LifeObserverSpy observer = new LifeObserverSpy();
        GameOfLife game = new GameOfLife(observer);

        game.advance(grid);

        Approvals.verify(observer.observed());
    }

    private Grid buildBlinkerGrid() {
        return new Grid(5, 5, (x, y) -> {
            if (x == 2) {
                return y == 1 || y == 2 || y == 3;
            }
            return false;
        });
    }

    private static class LifeObserverSpy implements LifeObserver {
        private Grid observed;

        public Grid observed() {
            return observed;
        }

        @Override
        public void observed(Grid grid) {
            observed = grid;
        }
    }
}
