package ch.heg.ig.business;

public class Tour {
    enum PhaseLoto {
        Quine,
        DoubleQuine,
        Carton
    }
    PhaseLoto phaseActuelle = PhaseLoto.Quine;

    Tirage tirageLoto = new Tirage();

    public void commencer(){
        //TODO
    }
    public void terminer(){
        //TODO
    }
    public void phaseSuivante(){
        if(this.phaseActuelle == PhaseLoto.Carton)
        {
            this.terminer(); // termine le jeu
        }
        else {
            PhaseLoto[] p = PhaseLoto.values();
            int i = 0;
            for (; p[i] != this.phaseActuelle; i++)
                ;
            i++;
            i %= p.length;
            this.phaseActuelle = p[i];
        }
    }

    public boolean verifCarton(CartonDeJeu cart) {
        boolean valid = false;
        switch (this.phaseActuelle) {
            case Quine:
                valid = new Quine().verif(cart,this.tirageLoto);
                break;
            case DoubleQuine:
                valid = new DoubleQuine().verif(cart,this.tirageLoto);
                break;
            case Carton:
                valid = new Carton().verif(cart,this.tirageLoto);
                break;
        }
        return valid;
    }
}
