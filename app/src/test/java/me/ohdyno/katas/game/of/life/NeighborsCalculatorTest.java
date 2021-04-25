package me.ohdyno.katas.game.of.life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighborsCalculatorTest {
    @Test
    void noNeighbors() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        final int result = calculator.calculate(0, 0, (_x, _y) -> false);
        assertEquals(0, result);
    }

    @Test
    void neighborsInTheSameRow() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        assertEquals(1, calculator.calculate(0, 0, (x, y) -> x == 0 && y == 1));
        assertEquals(1, calculator.calculate(0, 0, (x, y) -> x == 0 && y == -1));
        assertEquals(2, calculator.calculate(0, 0, (x, y) -> x == 0 && y == -1 || x == 0 && y == 1));
    }

    @Test
    void neighborsInTheSameColumn() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        assertEquals(1, calculator.calculate(0, 0, (x, y) -> x == 1 && y == 0));
        assertEquals(1, calculator.calculate(0, 0, (x, y) -> x == -1 && y == 0));
        assertEquals(2, calculator.calculate(0, 0, (x, y) -> x == 1 && y == 0 || x == -1 && y == 0));
    }
}
