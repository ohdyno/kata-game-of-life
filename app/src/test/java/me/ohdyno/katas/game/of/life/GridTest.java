package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter({ClipboardReporter.class, FileMergeReporter.class})
class GridTest {
    @Test
    void initializeGridWithNoLifeByDefault() {
        Approvals.verify(new Grid(1, 3));
    }

    @Test
    void initializeGridWithLife() {
        Approvals.verify(new Grid(1, 3, (_x, _y) -> true));
    }

    @Test
    void cellsDieByStarvingWithNoNeighbors() {
        Grid grid = new Grid(1, 1, (_x, _y) -> true);

        Approvals.verify(grid.advance());
    }

    @Test
    void cellSurviveWithTwoNeighbors() {
        Grid grid = new Grid(3, 3, (x, y) -> {
            boolean[][] cells = {
                    {true, false, false},
                    {false, true, false},
                    {false, false, true},
            };

            return cells[x][y];
        });

        Approvals.verify(grid.advance());
    }
}
