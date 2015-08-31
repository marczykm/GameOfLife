package pl.marczykm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MMARCZYK on 2015-08-31.
 */
public class MyPanel extends JPanel {

    private Board board;
    private Graphics2D g2d;

    public MyPanel(int width, int height) {

        board = new Board(30, width, height);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        redrawCells();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        board.redrawBoard();
    }

    private void redrawCells(){
        if (g2d != null){
            for (Cell cell : board.getCells()) {
                if (!cell.isDead())
                    g2d.drawRect(cell.getX(), cell.getY(), 1, 1);
            }
        }
    }
}
