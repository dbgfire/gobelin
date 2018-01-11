package environnement;
import unit�.*;

//Classe de la zone Pont

public class Ponts {
    public void CoutPM(infantery i){
        i.PM = i.PM - 1;
    }
    public void CoutPM(Cavalerie c){
        c.PM = c.PM - 1/2;
    }
    public void CoutPM(gobelin g){
        g.PM = g.PM - 1;
    }
}
