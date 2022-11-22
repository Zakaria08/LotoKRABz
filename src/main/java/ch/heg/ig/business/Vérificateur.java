package ch.heg.ig.business;

public class Vérificateur {
    public static boolean verifLigne1(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne1()){
            check = tirage.getNumerosSortis().contains(num);
            if (!check){
                return false;
            }
        }
        return true;
    }
    public static boolean verifLigne2(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne2()){
            check = tirage.getNumerosSortis().contains(num);
            if (!check){
                return false;
            }
        }
        return true;
    }
    public static boolean verifLigne3(CartonDeJeu carton , Tirage tirage)
    {
        boolean check = false;
        for (Integer num : carton.getLigne3()){
            check = tirage.getNumerosSortis().contains(num);
            if (!check){
                return false;
            }
        }
        return true;

    }

    public static boolean verifQuine(CartonDeJeu carton, Tirage tirage) {
        return(verifLigne1(carton, tirage) || verifLigne2(carton, tirage)|| verifLigne3(carton, tirage));
    }
    public static boolean verifDoubleQuine(CartonDeJeu carton , Tirage tirage) {
        return((verifLigne1(carton, tirage) && verifLigne2(carton, tirage)) || (verifLigne2(carton, tirage) && verifLigne3(carton, tirage)) || (verifLigne1(carton, tirage) && verifLigne3(carton, tirage)));
    }
    public static boolean verifCarton(CartonDeJeu carton, Tirage tirage) {
        return(verifLigne1(carton, tirage) && verifLigne2(carton, tirage) && verifLigne3(carton, tirage));
    }
}
