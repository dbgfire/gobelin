import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fenetre extends JFrame{

   public Fenetre() throws IOException {
        //nom fenetre
        this.setTitle("Gobelin le jeu");
        //taille fenetre
        this.setSize(500, 500);
        //position fenetre
        this.setLocationRelativeTo(null);
        //bouton quitter fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre visible
        this.setVisible(true);
    }


}



