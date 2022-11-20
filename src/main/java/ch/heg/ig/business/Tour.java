package ch.heg.ig.business;

import java.util.Scanner;

public class Tour {
    enum PhaseLoto {
        Quine,
        DoubleQuine,
        Carton
    }

    PhaseLoto phaseActuelle = PhaseLoto.Quine;

    boolean isRunning = false;

    Tirage tirageLoto = new Tirage();

    public void commencer() {
        Scanner command = new Scanner(System.in);
        while(!isRunning){
            System.out.println("Voulez-vous commencer une partie de loto ? (O/N)");
            String reponse = command.nextLine();
            if (reponse.equals("O")) {
                isRunning = true;
                System.out.println("Nous jouons pour la quine !");
            }
        }
    }

    public void terminer() {
        tirageLoto.toutEffacer();
        phaseActuelle = PhaseLoto.Quine;
        this.commencer();
    }

    public void phaseSuivante() {
        if (this.phaseActuelle == PhaseLoto.Carton) {
            this.terminer();
        } else {
            this.phaseActuelle = PhaseLoto.values()[this.phaseActuelle.ordinal() + 1];
        }
    }

    public boolean verifCarton(CartonDeJeu cart) {
        boolean valid = false;
        switch (this.phaseActuelle) {
            case Quine:
                valid = new Quine().verif(cart, this.tirageLoto);
                break;
            case DoubleQuine:
                valid = new DoubleQuine().verif(cart, this.tirageLoto);
                break;
            case Carton:
                valid = new Carton().verif(cart, this.tirageLoto);
                break;
        }
        return valid;
    }
}
