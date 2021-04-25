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
    void gameOfLifeAdvancesToNextWorldAndTheNewWorldCanBeObserved() {
        World world = new World();
        LifeObserverSpy observer = new LifeObserverSpy();
        GameOfLife game = new GameOfLife(observer);

        game.advance(world);

        Approvals.verify(observer.observedWorld());
    }

    private static class LifeObserverSpy implements LifeObserver {
        public World observedWorld() {
            return null;
        }
    }
}
