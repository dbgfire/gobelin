package unite;
abstract class Unity {
    public char morale;
    public int missile;
    public int corp;
    public int armure;
    public int PM;

    abstract void deplacement();// valeur de déplacement et action
    abstract void pillage();//option unique au gobelin
    public void attaquer(){
        System.out.println("attaque");
    }//mecanique d'attaque
    public void attaque_distance(){
        System.out.println("attaque_distance");
    }//mecanique d'attaque distance


}
