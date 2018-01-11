import javax.swing.*;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {


    public static void main(String[] args) {

        //menu me=new menu();//generation page d'acceuil
        try {
            Fenetre fenetre = new Fenetre();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
