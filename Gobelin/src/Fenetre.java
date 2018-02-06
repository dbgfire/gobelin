import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static java.awt.BorderLayout.NORTH;

public class Fenetre extends JFrame{
    JMenuBar menuBar = new JMenuBar();


    JMenuItem test1 = new JMenuItem("Mouvement gobelin");
    JMenuItem test2 = new JMenuItem ("Combat gobelin");
    JMenuItem test3 = new JMenuItem("Mouvement humain");
    JMenuItem test4 = new JMenuItem("Combat humain");
    JMenuItem test5 = new JMenuItem("Changement de tour");
    JMenu test6 = new JMenu("Fin phase       ");
    JMenu test7 = new JMenu("menu");




   public Fenetre() throws IOException {
       Toolkit tailleEcran = Toolkit.getDefaultToolkit();
       Image icone = Toolkit.getDefaultToolkit().getImage("images/mapold.png");
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

       Icon feuVert = new ImageIcon("D:\\projet\\gobelin\\Gobelin\\src\\images\\Pions\\baron+1.PNG");
       JLabel feuGreen = new JLabel("cc");
       feuGreen.setHorizontalTextPosition(SwingConstants.LEADING);
       feuGreen.setBounds(2,0,41,41);
       feuGreen.setHorizontalAlignment(SwingConstants.LEADING);

       feuGreen.setBorder(BorderFactory.createLineBorder(Color.RED));
      // feuGreen.setText("cc");
       feuGreen.setIcon(feuVert);
       feuGreen.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               System.out.println("Yay you clicked me");
           }

       });

      // feuGreen.setLocation(1000,500);
      // this.getContentPane().add(feuGreen);
       //a.add(feuGreen);
       Icon feu = new ImageIcon("D:\\projet\\gobelin\\Gobelin\\src\\images\\Pions\\baron+2.PNG");
       JLabel feuv = new JLabel("cc");
       feuv.setHorizontalTextPosition(SwingConstants.LEADING);
       feuv.setBounds(500,0,41,41);
       feuv.setHorizontalAlignment(SwingConstants.LEADING);


       feuv.setBorder(BorderFactory.createLineBorder(Color.RED));
       // feuGreen.setText("cc");
       feuv.setIcon(feu);
       feuv.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               System.out.println("Yay you  me");
           }

       });
       // a.add(feuv);
      // this.getContentPane().add(a);
       // feuGreen.setLocation(1000,500);
       //this.getContentPane().add(feuv);
       this.pack();

       //this.add(feuGreen); // Ajout à la JFrame
/*
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





               this.setJMenuBar(menuBar);*/
               this.setVisible(true);

    }


}



