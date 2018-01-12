import javax.swing.*;
import java.awt.*;

public class hexagone extends JPanel {
    public hexagone() {

    }
    public void paintComponent(Graphics g){

        int xpoints[] = {10, 10, 20, 30, 30, 20};
        int ypoints[] = {20, 30, 35, 30, 20, 14};
        int npoints = 6;




        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 26; j++) {
                g.drawPolygon(xpoints, ypoints, npoints);
            }

        }

    }
}