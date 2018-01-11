import unité.*;

import javax.swing.*;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {


    public static void main(String[] args) throws IOException {

        menu me=new menu();//generation page d'acceuil
        gobelin inf=new gobelin() ;
        Cavalerie cav=new Cavalerie();
        inf.deplacement();
        cav.deplacement();
        cav.attaquer();


    }

}
