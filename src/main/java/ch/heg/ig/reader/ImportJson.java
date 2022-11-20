package ch.heg.ig.reader;

import ch.heg.ig.business.CartonDeJeu;
import ch.heg.ig.business.ListCartonDeJeu;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class ImportJson {
    public List<CartonDeJeu> importCartonDeJeu() throws IOException {
        ListCartonDeJeu listCartonDeJeu = null;
        try {
            ObjectMapper om = new ObjectMapper();
            listCartonDeJeu = om.readValue(new File("Students.json"), ListCartonDeJeu.class);

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return listCartonDeJeu.getCartonsDeJeu();
    }
}

