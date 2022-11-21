package ch.heg.ig.reader;

import ch.heg.ig.business.CartonDeJeu;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListCartonDeJeu {
    @JsonProperty("CartonDeJeu")
    private List<CartonDeJeu> cartonsDeJeu = new ArrayList<>();

    public ListCartonDeJeu() {
    }

    public List<CartonDeJeu> getCartonsDeJeu() {
        return cartonsDeJeu;
    }

    public void setCartonsDeJeu(List<CartonDeJeu> cartonsDeJeu) {
        this.cartonsDeJeu = cartonsDeJeu;
    }
}
