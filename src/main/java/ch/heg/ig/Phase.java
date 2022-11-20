package ch.heg.ig;

public abstract class Phase {
    public abstract boolean verif(CartonDeJeu carton,Tirage tirage);
    public boolean verifLigne1(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne1()){
            check = tirage.getNumerosSortis().contains(num);
            if (check == false){
                return false;
            }
        }
        return true;
    }
    public boolean verifLigne2(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne2()){
            check = tirage.getNumerosSortis().contains(num);
            if (check == false){
                return false;
            }
        }
        return true;
    }
    public boolean verifLigne3(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne3()){
            check = tirage.getNumerosSortis().contains(num);
            if (check == false){
                return false;
            }
        }
        return true;

    }
}
