package me.ohdyno.katas.game.of.life;

public class Grid {
    private final int width;
    private final int height;
    private final LifeCreator creator;
    private final MemoizedPrinter memoizedPrinter;

    public Grid(int width, int height) {
        this(width, height, (_x, _y) -> false);
    }

    public Grid(int width, int height, LifeCreator creator) {
        this.width = width;
        this.height = height;
        this.creator = new BoundedLifeCreator(width, height, creator);
        this.memoizedPrinter = new MemoizedPrinter(this);
    }

    public Grid(int width, int height, boolean[][] cells) {
        this(width, height, ((x, y) -> cells[x][y]));
    }

    public Grid advance() {
        return new Grid(width, height, this::livesNextGeneration);
    }

    private boolean livesNextGeneration(int x, int y) {
        int neighbors = new NeighborsCalculator().calculate(x, y, creator);
        if (neighbors == 3) {
            return true;
        }
        return creator.lifeExistsAt(x, y) && neighbors == 2;
    }

    @Override
    public String toString() {
        return memoizedPrinter.print();
    }

    private static class BoundedLifeCreator implements LifeCreator {
        private final int width;
        private final int height;
        private final LifeCreator creator;

        public BoundedLifeCreator(int width, int height, LifeCreator creator) {
            this.width = width;
            this.height = height;
            this.creator = creator;
        }

        @Override
        public boolean lifeExistsAt(int x, int y) {
            if (isOutOfBound(y, height) || isOutOfBound(x, width)) {
                return false;
            }
            return this.creator.lifeExistsAt(x, y);
        }

        private boolean isOutOfBound(int n, int boundary) {
            return n < 0 || n >= boundary;
        }
    }

    private static class MemoizedPrinter {
        private final Grid grid;
        private String memoized;

        public MemoizedPrinter(Grid grid) {
            this.grid = grid;
        }

        private String print() {
            if (memoized == null) {
                return printAndMemoize(grid);
            }
            return memoized;
        }

        private String printAndMemoize(Grid grid) {
            this.memoized = freshPrint(grid);
            return memoized;
        }

        private String freshPrint(Grid grid) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < grid.width; i++) {
                for (int j = 0; j < grid.height; j++) {
                    String mark;
                    if (grid.creator.lifeExistsAt(i, j)) {
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
}
