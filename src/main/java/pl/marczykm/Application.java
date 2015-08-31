package pl.marczykm;

import java.awt.*;

/**
 * Created by MMARCZYK on 2015-08-31.
 */
public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame();
            }
        });
    }
}
