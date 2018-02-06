import Leader.*;
import unite.*;

import javax.swing.*;
import java.io.IOException;
import javax.swing.JFrame;


public class Main {


    public static void main(String[] args) throws IOException {
       // Fenetre f=new Fenetre();

        menu me=new menu();//generation page d'acceuil
        Hex h=new Hex();

        leaderHumain john = new leaderHumain("John Gordon",2,2,1,true);
        leaderHumain Robert = new leaderHumain("Rombert Keith",2,4,0,true);
        leaderHumain Thomas = new leaderHumain("Thomas Bruce",2,4,0,true);
        leaderHumain Friar = new leaderHumain("Friar Simon",2,5,1,true);
        leaderHumain Randolph = new leaderHumain("Sir Randolph",1,5,1,true);
        leaderHumain Godfrey = new leaderHumain("Sir Godfrey",1,5,1,true);
        leaderHumain Hubert = new leaderHumain("Sir Hubert",1,5,1,true);
        leaderHumain Count = new leaderHumain("Count",1,8,2,true);
        leaderHumain Baron = new leaderHumain("Baron",1,12,2,true);
        gobelin inf=new gobelin('A',3,2,1,10) ;
        //Cavalerie cav=new Cavalerie();
       inf.deplacement();
        //cav.deplacement();
        //cav.attaquer();
        leaderGobelin Phinloc = new leaderGobelin("Phinloc",2,5,1,10);
        leaderGobelin Uglop = new leaderGobelin("Uglop",3,5,0,10);
        leaderGobelin Grinphar = new leaderGobelin("Uglop",3,3,0,10);
        leaderGobelin Kasbosh = new leaderGobelin("Kasbosh",1,8,1,10);
        leaderGobelin Argbarg = new leaderGobelin("Argbarg",2,3,1,10);
        leaderGobelin Marglush= new leaderGobelin("Marglush",1,8,1,10);
        leaderGobelin King = new leaderGobelin("King",1,12,2,10);
    }

}
