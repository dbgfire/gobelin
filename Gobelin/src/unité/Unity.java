package unité;
abstract class Unity {
    private char morale;
    private int missile;
    private int corp;
    private int armure;
    private int PM;

    abstract void deplacement();
    abstract void pillage();
    public void attaquer(){
        System.out.println("attaque");
    }
    public void attaque_distance(){
        System.out.println("attaque_distance");
    }


}
