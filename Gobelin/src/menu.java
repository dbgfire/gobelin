import javax.swing.*;
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
        //redimensionnable
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        //this.setResizable(false);
        this.setVisible(true);
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
                principal.invalidate();
                principal.revalidate();
                principal.repaint();
            }
        });
        raidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"test");
            }
        });
        campagneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}
