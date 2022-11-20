package ch.heg.ig.business;

import ch.heg.ig.reader.ImportJson;
import com.sun.source.tree.DoWhileLoopTree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MatchAuLoto {
    public Map<String, CartonDeJeu> cartons = new HashMap<>();

    public void loadCartons() {
        this.cartons = ImportJson.importCartonDeJeu();
    }

    public CartonDeJeu getCarton(String id) {
        return this.cartons.get(id);
    }

    public void run() {
        this.loadCartons();
        Tour tour = new Tour();
        tour.commencer();
        String CommandeEntree = "";
        do {
            do {
                System.out.println("Entrer un numéro ou une commande valide :");
                Scanner command = new Scanner(System.in);
                String reponse = command.nextLine();
                CommandeEntree = reponse;
                //if response is a number
                if (reponse.matches("[0-9]+")) {
                    int num = Integer.parseInt(reponse);
                    if (num > 0 && num < 91) {
                        tour.tirageLoto.ajouter(num);
                        System.out.println("Le numéro " + num + " a été ajouté au tirage");
                    } else {
                        System.out.println("Le numéro " + num + " n'est pas valide");
                    }
                }
            }
            while (CommandeEntree == "Q" || CommandeEntree == "q" || CommandeEntree == "N" || CommandeEntree == "n" || CommandeEntree == "V" || CommandeEntree == "v");
            switch (CommandeEntree) {
                case "Q":
                case "q":
                    tour.terminer();
                    System.out.println("Vous avez quitté le jeu");
                    break;
                case "N":
                case "n":
                    tour.phaseSuivante();
                    break;
                case "V":
                case "v":
                    System.out.println("Entrer l'identifiant du carton à vérifier :");
                    Scanner command2 = new Scanner(System.in);
                    String reponse2 = command2.nextLine();
                    //Check if the carton exist
                    if (this.cartons.containsKey(reponse2)) {
                        CartonDeJeu carton = this.getCarton(reponse2);
                        if (tour.verifCarton(carton)) {
                            System.out.println("Le carton " + reponse2 + " est gagnant");
                        } else {
                            System.out.println("Le carton " + reponse2 + " n'est pas gagnant");
                        }
                    } else {
                        System.out.println("Le carton " + reponse2 + " n'existe pas");
                    }
                    break;
            }
        } while (CommandeEntree == "Q" || CommandeEntree == "q");
    }
}
