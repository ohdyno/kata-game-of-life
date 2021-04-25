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
        final int atX = 0;
        final int atY = 0;
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX && y == atY + 1));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX && y == atY - 1));
        assertEquals(2, calculator.calculate(atX, atY, (x, y) -> x == atX && y == atY - 1 || x == atX && y == atY + 1));
    }

    @Test
    void neighborsInTheSameColumn() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        final int atX = 0;
        final int atY = 0;
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX - 1 && y == atY));
        assertEquals(2, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY || x == atX - 1 && y == atY));
    }

    @Test
    void neighborsInTheCorners() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        final int atX = 0;
        final int atY = 0;

        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY + 1));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX - 1 && y == atY - 1));
        assertEquals(2, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY + 1 || x == atX - 1 && y == atY - 1));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX - 1 && y == atY + 1));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY - 1));
        assertEquals(2, calculator.calculate(atX, atY, (x, y) -> x == atX - 1 && y == atY + 1 || x == atX + 1 && y == atY - 1));
    }

    @Test
    void selfIsNotCountedAmongTheNeighbors() {
        final NeighborsCalculator calculator = new NeighborsCalculator();
        final int atX = 0;
        final int atY = 0;
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX + 1 && y == atY || x == atX && y == atY));
        assertEquals(1, calculator.calculate(atX, atY, (x, y) -> x == atX && y == atY + 1 || x == atX && y == atY));
    }
}
