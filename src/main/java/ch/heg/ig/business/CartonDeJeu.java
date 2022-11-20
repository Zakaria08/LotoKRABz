package ch.heg.ig.business;

public class CartonDeJeu {

    private int id ;
    private int[] ligne1;
    private int[] ligne2;
    private int[] ligne3;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getLigne1() {
        return ligne1;
    }

    public void setLigne1(int[] ligne1) {
        this.ligne1 = ligne1;
    }

    public int[] getLigne2() {
        return ligne2;
    }

    public void setLigne2(int[] ligne2) {
        this.ligne2 = ligne2;
    }

    public int[] getLigne3() {
        return ligne3;
    }

    public void setLigne3(int[] ligne3) {
        this.ligne3 = ligne3;
    }
}
