package ch.heg.ig.business;

import java.util.Scanner;

public class Console {



    public void run() {

        Tour tour = new Tour();
        tour.loadCartons();
        tour.commencer();
        String CommandeEntree = "";
        do {
            do {
                System.out.println("Entrer un numéro ou une commande valide :");
                Scanner command = new Scanner(System.in);
                CommandeEntree = command.nextLine();
                //if response is a number
                if (CommandeEntree.matches("[0-9]+")) {
                    int num = Integer.parseInt(CommandeEntree);
                    if (num > 0 && num < 91) {
                        if(!tour.getTirageLoto().checkNum(num)) {
                            tour.getTirageLoto().ajouter(num);
                            System.out.println("Le numéro " + num + " a été ajouté au tirage");
                        }
                        else {
                            System.out.println("Le numéro " + num + " déjà sorti");
                        }
                    } else {
                        System.out.println("Le numéro " + num + " n'est pas valide");
                    }
                }
            }
            while (!CommandeEntree.equals("Q") && !CommandeEntree.equals("q") && !CommandeEntree.equals("S") && !CommandeEntree.equals("s") && !CommandeEntree.equals("V") && !CommandeEntree.equals("v"));
            switch (CommandeEntree) {
                case "Q":
                case "q":
                    tour.terminer();
                    System.out.println("Vous avez quitté le jeu");
                    break;
                case "S":
                case "s":
                    tour.phaseSuivante();
                    if (tour.getPhaseActuelle() == Tour.PhaseLoto.DoubleQuine) {
                        System.out.println("Nous jouons pour la double quine !");
                    } else if (tour.getPhaseActuelle() == Tour.PhaseLoto.Carton) {
                        System.out.println("Nous jouons pour le carton plein !");
                    }
                    break;
                case "V":
                case "v":
                        System.out.println("Entrer l'identifiant du carton à vérifier :");
                        Scanner command2 = new Scanner(System.in);
                        CommandeEntree = command2.nextLine();
                        //Check if the carton exist
                        if (tour.getCartons().containsKey(CommandeEntree)) {
                            CartonDeJeu carton = tour.getCarton(CommandeEntree);
                            if (tour.verifCarton(carton)) {
                                System.out.println("Le carton " + CommandeEntree + " est gagnant");
                            } else {
                                System.out.println("Le carton " + CommandeEntree + " n'est pas gagnant");
                            }
                        } else {
                            System.out.println("Le carton " + CommandeEntree + " n'existe pas");
                        }
                    break;
            }
        } while (!CommandeEntree.equals("Q") && !CommandeEntree.equals("q"));
    }
}
