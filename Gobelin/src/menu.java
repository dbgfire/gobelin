import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class menu extends JFrame {
    //Déclaration des variables pour le menu
    private JButton icone1=new JButton();
    private JButton raidButton;
    private JButton optionsButton;
    private JButton campagneButton;
    private JButton quitterButton;
    private JPanel principal;
    private JPanel Menu;
    private JButton tutorielButton;
    int tour=0;
    //Déclaration des variables pour le jeu
    JMenuBar menuBar = new JMenuBar();
    JMenuItem test1 = new JMenuItem("Mouvement Gobelin");
    JMenuItem test2 = new JMenuItem ("Combat Gobelin");
    JMenuItem test3 = new JMenuItem("Mouvement Humain");
    JMenuItem test4 = new JMenuItem("Combat Humain");
    JMenuItem test5 = new JMenuItem("Passage au tour "+tour);
    JMenu test6 = new JMenu("Fin phase       ");
    JMenu test7 = new JMenu("menu");


    //Constructeur
    menu(){

        //nom fenetre
        this.setTitle("Gobelin le jeu");
        //position fenetre
        this.setLocationRelativeTo(null);

        //bouton quitter fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(principal);
        Menu=principal;

        //redimensionnable
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        //this.setResizable(false);
        this.setVisible(true);
        setJMenuBar(menuBar);

        //Definition couleur element menu jeu

        menuBar.setBackground(new Color(11,201,6));
        test2.setBackground(new Color(11,201,6));
        test3.setBackground(new Color(11,201,6));
        test4.setBackground(new Color(11,201,6));
        test5.setBackground(new Color(11,201,6));
        test2.setBackground(new Color(11,201,6));

        test1.setEnabled(false);
        test2.setEnabled(false);
        test3.setEnabled(false);
        test4.setEnabled(false);
        test5.setEnabled(false);
        //action bouton fin de phase

        test6.addMenuListener(new MenuListener() {
            int i=1;//valeur du selecteur de phase

            @Override
            public void menuSelected(MenuEvent e) {
                //
                if(i>4) i = 0;//pour boucler a l'infini
                    switch (i){//change la couleur en fonction de la phase
                    case 0:
                        test1.setBackground(new Color(255, 255, 255));
                        test5.setBackground(new Color(11,201,6));
                        i=i+1;
                        break;
                    case 1:
                        test1.setBackground(new Color(11,201,6));
                        test2.setBackground(new Color(255, 255, 255));
                        i=i+1;
                        break;
                    case 2:
                        test2.setBackground(new Color(11,201,6));
                        test3.setBackground(new Color(255, 255, 255));
                        i=i+1;
                        break;
                    case 3:
                        test3.setBackground(new Color(11,201,6));
                        test4.setBackground(new Color(255, 255, 255));
                        i=i+1;
                        break;
                    case 4:
                        test4.setBackground(new Color(11,201,6));
                        test5.setBackground(new Color(255, 255, 255));
                        i=i+1;
                        tour++;
                        test5.setText("Passage au tour "+tour);
                        break;
                }


            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        //action bouton menu
        test7.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.exit(0);
              /*  principal.removeAll();
                principal=Menu;
                remove(menuBar);
                setContentPane(principal);
               principal.add(raidButton);
                principal.add(optionsButton);
                principal.add( campagneButton);
                principal.add( quitterButton);


                principal.invalidate();
                principal.revalidate();
                principal.repaint();*/

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        //action bouton quitter
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //action bouton tuto
        tutorielButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //generation plateau de jeu
                Menu.removeAll();
                Menu=new hex.Panneau();
                Icon feuVert = new ImageIcon("images/Pions/Ash_Down.PNG");
                JLabel feuGreen = new JLabel();
                feuGreen.setText("cc");
                feuGreen.setIcon(feuVert);
                feuGreen.setBounds(1000,500,41,41);

                Menu.add(feuGreen); // Ajout à la JFrame


                //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
                //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
                setContentPane(Menu);
                menuBar.add(test1);
                menuBar.add(test2);
                menuBar.add(test3);
                menuBar.add(test4);
                menuBar.add(test5);
                menuBar.add(test6);
                menuBar.add(test7);

                setJMenuBar(menuBar);
                Menu.invalidate();
                Menu.revalidate();
                Menu.repaint();
            }
        });
        //action bouton raid
        raidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
        //action bouton campagne
        campagneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
        //action bouton options
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
    }



}
