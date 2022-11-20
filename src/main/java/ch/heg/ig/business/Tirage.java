package ch.heg.ig.business;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

public class Tirage {

    Set<Integer> numerosSortis = new HashSet<>();

    public Set<Integer> getNumerosSortis() {
        return numerosSortis;
    }

    public void setNumerosSortis(Set<Integer> numerosSortis) {
        this.numerosSortis = numerosSortis;
    }

    public void ajouter (Integer num){
        this.numerosSortis.add(num);
    }
    public void toutEffacer (){
        this.numerosSortis.clear();
    }

}
