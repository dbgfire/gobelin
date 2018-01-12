import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.BorderLayout.NORTH;

public class Fenetre extends JFrame{

   public Fenetre() throws IOException {
       Toolkit tailleEcran = Toolkit.getDefaultToolkit();
       Image icone = Toolkit.getDefaultToolkit().getImage("images/Goblin_map1.jpg");
       setIconImage(icone);
       //nom fenetre
        this.setTitle("Gobelin le jeu");
        //taille fenetre
        //this.setSize(500, 500);
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       this.setUndecorated(true);
        //position fenetre
        this.setLocationRelativeTo(null);
        //bouton quitter fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //fenetre visible
        this.setVisible(true);
    }


}



