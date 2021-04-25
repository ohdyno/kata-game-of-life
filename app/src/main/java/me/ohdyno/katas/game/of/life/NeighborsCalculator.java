package me.ohdyno.katas.game.of.life;

public class NeighborsCalculator {
    public int calculate(int x, int y, LifeCreator creator) {
        int neighbors = 0;
        if (creator.lifeExistsAt(x + 1, y - 1)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x - 1, y - 1)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x + 1, y + 1)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x - 1, y + 1)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x, y - 1)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x - 1, y)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x + 1, y)) {
            neighbors++;
        }
        if (creator.lifeExistsAt(x, y + 1)) {
            neighbors++;
        }
        return neighbors;
    }
}
