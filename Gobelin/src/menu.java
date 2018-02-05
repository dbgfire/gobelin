import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class menu extends JFrame {
    private JButton raidButton;
    private JButton optionsButton;
    private JButton campagneButton;
    private JButton quitterButton;
    private JPanel principal;
    private JPanel Menu;
    private JButton tutorielButton;
    JMenuBar menuBar = new JMenuBar();


    JMenuItem test1 = new JMenuItem("Mouvement gobelin");
    JMenuItem test2 = new JMenuItem ("Combat gobelin");
    JMenuItem test3 = new JMenuItem("Mouvement humain");
    JMenuItem test4 = new JMenuItem("Combat gobelin");
    JMenuItem test5 = new JMenuItem("Changement de tour");
    JMenu test6 = new JMenu("Fin phase       ");
    JMenu test7 = new JMenu("menu");

    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected: " + e.getActionCommand());

        }
    }
    menu(){

        //nom fenetre
        this.setTitle("Gobelin le jeu");
        //taille fenetre
        //this.setSize(500, 400);
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

        test6.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(null,"sele");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                JOptionPane.showMessageDialog(null,"des");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
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
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        tutorielButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                principal.removeAll();
                principal=new hex.Panneau();

                setContentPane(principal);
                menuBar.add(test1);
                menuBar.add(test2);
                menuBar.add(test3);
                menuBar.add(test4);
                menuBar.add(test5);
                menuBar.add(test6);
                menuBar.add(test7);

                setJMenuBar(menuBar);
                principal.invalidate();
                principal.revalidate();
                principal.repaint();
            }
        });
        raidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
        campagneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Désolé ce n'est pas encore implenter dans le jeu");
            }
        });
    }



}
