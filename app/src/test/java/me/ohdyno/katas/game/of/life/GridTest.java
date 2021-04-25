package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter({ClipboardReporter.class, FileMergeReporter.class})
class GridTest {
    @Test
    void initializeGridWithNoLifeByDefault() {
        Approvals.verify(new Grid(1,3));
    }

    @Test
    void initializeGridWithLife() {
        Approvals.verify(new Grid(1,3, (_x, _y) -> true));
    }
}
