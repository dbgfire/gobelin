package unité;
abstract class Unity {
    public char morale;
    public int missile;
    public int corp;
    public int armure;
    public int PM;

    abstract void deplacement();
    abstract void pillage();
    public void attaquer(){
        System.out.println("attaque");
    }
    public void attaque_distance(){
        System.out.println("attaque_distance");
    }


}
