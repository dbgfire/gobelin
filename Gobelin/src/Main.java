<<<<<<< Updated upstream
import javax.swing.*;

=======
import javax.swing.JFrame;
>>>>>>> Stashed changes
public class Main {

    public static void main(String[] args) {

<<<<<<< Updated upstream
        JFrame fenetre = new JFrame();
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Goblin");
        //Définit sa taille : 600 pixels de large et 400 pixels de haut
        fenetre.setSize(3000, 2000);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        fenetre.setVisible(true);
=======
        System.out.println("Hello World!");
        JFrame fenetre = new JFrame();
        fenetre.setVisible(true);
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("goblin");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(3000, 2000);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);

>>>>>>> Stashed changes
    }
}
