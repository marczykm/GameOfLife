package pl.marczykm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MMARCZYK on 2015-08-31.
 */
public class MyFrame extends JFrame {

    private int width = 800;
    private int height = 600;

    public MyFrame() throws HeadlessException {
        super("Game Of Life");
        JPanel panel = new MyPanel(width, height);

        add(panel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }
}
