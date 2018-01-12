import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Fenetre extends JFrame{
    JMenuBar menuBar = new JMenuBar();


    JMenuItem test1 = new JMenuItem("Mouvement gobelin");
    JMenuItem test2 = new JMenuItem ("Combat gobelin");
    JMenuItem test3 = new JMenuItem("Mouvement humain");
    JMenuItem test4 = new JMenuItem("Combat gobelin");
    JMenuItem test5 = new JMenuItem("Changement de tour");
    JMenu test6 = new JMenu("Fin phase       ");
    JMenu test7 = new JMenu("menu");




   public Fenetre() throws IOException {
        //nom fenetre
        this.setTitle("Gobelin le jeu");
        //taille fenetre
        this.setSize(1000, 1000);
        //position fenetre
        this.setLocationRelativeTo(null);
        //bouton quitter fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //fenetre visible
        this.setVisible(true);

       setJMenuBar(menuBar);

       menuBar.setBackground(new Color(11,201,6));
       test2.setBackground(new Color(11,201,6));
       test3.setBackground(new Color(11,201,6));
       test4.setBackground(new Color(11,201,6));
       test5.setBackground(new Color(11,201,6));
       test2.setBackground(new Color(11,201,6));


       //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
               //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier



               test1.setEnabled(false);
               test2.setEnabled(false);
               test3.setEnabled(false);
               test4.setEnabled(false);
               test5.setEnabled(false);

               this.menuBar.add(test1);
               this.menuBar.add(test2);
               this.menuBar.add(test3);
               this.menuBar.add(test4);
               this.menuBar.add(test5);
               this.menuBar.add(test6);
               this.menuBar.add(test7);





               this.setJMenuBar(menuBar);
               this.setVisible(true);

    }


}



