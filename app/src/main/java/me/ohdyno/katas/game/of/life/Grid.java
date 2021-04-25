package me.ohdyno.katas.game.of.life;

public class Grid {
    private final int width;
    private final int height;
    private final LifeCreator creator;

    public Grid(int width, int height) {
        this(width, height, (_x, _y) -> false);
    }

    public Grid(int width, int height, LifeCreator creator) {
        this.width = width;
        this.height = height;
        this.creator = creator;
    }

    public Grid advance() {
        return new Grid(width, height);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String mark;
                if (creator.lifeExistsAt(i, j)) {
                    mark = "o";
                } else {
                    mark = "_";
                }
                builder.append(mark).append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
