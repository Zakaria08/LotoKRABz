package ch.heg.ig.reader;

import ch.heg.ig.business.CartonDeJeu;
import ch.heg.ig.business.ListCartonDeJeu;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class ImportJson {
    public static HashMap<String, CartonDeJeu> importCartonDeJeu() {
        ListCartonDeJeu listCartonDeJeu = null;
        HashMap<String, CartonDeJeu> output = null;
        try {
            ObjectMapper om = new ObjectMapper();
            listCartonDeJeu = om.readValue(new File("data/CartonsDeLoto.json"), ListCartonDeJeu.class);
            output = new HashMap<>();
            for (CartonDeJeu cartonDeJeu : listCartonDeJeu.getCartonsDeJeu()) {
                output.put(cartonDeJeu.getId(), cartonDeJeu);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return output;
    }
}
