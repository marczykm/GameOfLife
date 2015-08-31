package pl.marczykm;

import java.util.*;

/**
 * Created by MMARCZYK on 2015-08-31.
 */
public class Board {
    private int numberOfCells;
    private int width;
    private int height;
    private Set<Cell> cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board(int numberOfCells, int width, int height) {
        this.numberOfCells = numberOfCells;
        this.width = width;
        this.height = height;

        this.initializeBoard();
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    private void initializeBoard() {
        cells = new HashSet<Cell>();

        Random randomGenerator = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (randomGenerator.nextInt(100) >= 90)
                    cells.add(new Cell(x, y, false));
                else
                    cells.add(new Cell(x, y, true));
            }
        }
    }

    public void redrawBoard() {
        Set<Cell> copy = new HashSet<Cell>();
        for (Cell cell : cells) {
            cell.setDead(!shouldLive(cell));
            copy.add(cell);
        }
        cells = copy;
    }

    private boolean shouldLive(Cell cell) {
        if (cell.isDead() && countNeighboars(cell) == 3) {
            return true;
        } else if (!cell.isDead() && (countNeighboars(cell) != 2 && countNeighboars(cell) != 3)) {
            return false;
        }
        return false;
    }

    private int countNeighboars(Cell cell) {
        int numberOfNeighboars = 0;
        for (Cell c : cells) {
            if (c.getX() - cell.getX() <= Math.abs(1) && c.getY() - cell.getY() <= Math.abs(1)) {
                numberOfNeighboars++;
            }
        }

        return numberOfNeighboars;

    }
}
