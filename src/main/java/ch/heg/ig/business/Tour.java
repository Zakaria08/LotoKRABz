package ch.heg.ig.business;

import ch.heg.ig.reader.ImportJson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tour {
    public Map<String, CartonDeJeu> cartons = new HashMap<>();
    public void loadCartons() {
        this.cartons = ImportJson.importCartonDeJeu();
    }
    public CartonDeJeu getCarton(String id) {
        return this.cartons.get(id);
    }
    enum PhaseLoto {
        Quine,
        DoubleQuine,
        Carton
    }

    private PhaseLoto phaseActuelle = PhaseLoto.Quine;

    private Tirage tirageLoto = new Tirage();

    public void commencer() {
        boolean isRunning = false;
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

    public boolean verifCarton(CartonDeJeu carton) {
        boolean valid = false;
        switch (this.phaseActuelle) {
            case Quine:
                valid = Vérificateur.verifQuine(carton, this.tirageLoto);
                break;
            case DoubleQuine:
                valid = Vérificateur.verifDoubleQuine(carton, this.tirageLoto);
                break;
            case Carton:
                valid = Vérificateur.verifCarton(carton, this.tirageLoto);
                break;
        }
        return valid;
    }

    public Tirage getTirageLoto() {
        return tirageLoto;
    }

    public void setTirageLoto(Tirage tirageLoto) {
        this.tirageLoto = tirageLoto;
    }

    public PhaseLoto getPhaseActuelle() {
        return phaseActuelle;
    }

    public void setPhaseActuelle(PhaseLoto phaseActuelle) {
        this.phaseActuelle = phaseActuelle;
    }

    public Map<String, CartonDeJeu> getCartons() {
        return cartons;
    }

    public void setCartons(Map<String, CartonDeJeu> cartons) {
        this.cartons = cartons;
    }
}
