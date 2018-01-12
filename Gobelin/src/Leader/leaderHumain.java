package Leader;

public class leaderHumain extends Leader{
    public leaderHumain(String NomLeader,int Armure, int UniteMax, int Morale,boolean m){

        this.NomLeader = NomLeader;
        this.Armure = Armure;
        this.UniteMax = UniteMax;
        this.Morale = Morale;
        this.Monture=m;
        if(this.Monture == true){
            this.PM=15;
        }else {
            this.PM=10;
        }
    }
    public void Cheval(boolean A){
        this.Monture=A;
        if(this.Monture == true){                   //défini les PM disponnibles si cheval ou non
            this.PM=15;
        }else {
            this.PM=10;
    }

    }


}
