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
            for(int y = 0; y < height; y++) {
                if (randomGenerator.nextInt(100) >= 90)
                    cells.add(new Cell(x, y, false));
                else
                    cells.add(new Cell(x, y, true));
            }
        }
    }

    private boolean shouldLive(Cell cell){
        return false;
    }

    private boolean shouldBecomeAlive(Cell cell) {
        if (countNeighboars(cell) == 3)
            return true;
        return false;
    }

    private boolean shouldStayAlive(Cell cell) {
        if (countNeighboars(cell) == 2 || countNeighboars(cell)==3)
            return true;
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
