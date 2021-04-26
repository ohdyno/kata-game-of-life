package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter({ClipboardReporter.class, FileMergeReporter.class})
class GridTest {
    @Test
    void initializeGridWithLifeCreator() {
        Approvals.verify(new Grid(1, 3, (_x, _y) -> true));
    }

    @Test
    void initializeGridWith2DArray() {
        Approvals.verify(new Grid(3, 3, new boolean[][]{
                {true, false, false},
                {false, false, false},
                {true, false, true},
        }));
    }

    @Test
    void cellsDieByStarvingWithNoNeighbors() {
        Grid grid = new Grid(1, 1, (_x, _y) -> true);

        Approvals.verify(grid.advance());
    }

    @Test
    void cellSurviveWithTwoNeighbors() {
        Grid grid = new Grid(3, 3, new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, true},
        });

        Approvals.verify(grid.advance());
    }

    @Test
    void cellIsRebornWithThreeNeighbors() {
        Grid grid = new Grid(3, 3, new boolean[][]{
                {true, false, false},
                {false, false, false},
                {true, false, true},
        });

        Approvals.verify(grid.advance());
    }

    @Test
    void cellDiesWithMoreThanThreeNeighbors() {
        Grid grid = new Grid(3, 3, new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true},
        });

        Approvals.verify(grid.advance());
    }
}
