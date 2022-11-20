package ch.heg.ig.business;

import ch.heg.ig.reader.ImportJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MatchAuLoto {
    public Map<String,CartonDeJeu> cartons = new HashMap<>();

    public void loadCartons() {
        this.cartons = ImportJson.importCartonDeJeu();
    }
    public CartonDeJeu getCarton(String id){
       return  this.cartons.get(id);
    }
}
