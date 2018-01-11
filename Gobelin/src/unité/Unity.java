package unité;

public abstract class Unity {
    private char morale;
    private int missile;
    private int corp;
    private int armure;
    private int PM;

    abstract void deplacement();
    abstract void pillage();
    void attaquer(){}
    void attaque_distance(){}


}
