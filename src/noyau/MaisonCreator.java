package noyau;

import java.util.LinkedList;
import java.util.List;

public class MaisonCreator extends BienCreator{
    @Override
    public Bien CreerBien(List<Object> list) {
        Maison maison = new Maison((User) list.get(0),(String)list.get(1),(String)list.get(2),(Wilaya)list.get(3),(int)list.get(4),
                (Nature) list.get(5),(double)list.get(6),(boolean)list.get(7),(String)list.get(8),(String)list.get(9),(java.util.LinkedList<String>)list.get(10),
                (boolean)list.get(11),(int)list.get(12),(int)list.get(13),(boolean)list.get(14),(boolean)list.get(15),(boolean)list.get(16),(int)list.get(17));
        CalculerPrixMaison calculerPrixMaison = new CalculerPrixMaison();
        calculerPrixMaison.calculerPrix(maison);
        return maison;
    }
}
