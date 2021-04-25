package me.ohdyno.katas.game.of.life;

public class NeighborsCalculator {
    public int calculate(int x, int y, LifeCreator creator) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                final int neighborX = x + i;
                final int neighborY = y + j;
                if (neighborX == x && neighborY == y) {
                    continue;
                }
                if (creator.lifeExistsAt(neighborX, neighborY)) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }
}
