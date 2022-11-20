package ch.heg.ig.business;

public class Quine extends Phase {
    @Override
    public boolean verif(CartonDeJeu carton, Tirage tirage) {
        return(super.verifLigne1(carton, tirage) || super.verifLigne2(carton, tirage)|| super.verifLigne3(carton, tirage));
    }
}
