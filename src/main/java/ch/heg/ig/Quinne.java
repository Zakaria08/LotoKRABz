package ch.heg.ig;

public class Quinne extends Phase{
    @Override
    public boolean verif(CartonDeJeu carton,Tirage tirage) {
        return(super.verifLigne1(carton, tirage) || super.verifLigne2(carton, tirage)|| super.verifLigne3(carton, tirage));
    }
}
