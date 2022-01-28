package noyau;

import java.util.LinkedList;
import java.util.List;

public class AppartementCreator extends BienCreator{

    @Override
    public Bien CreerBien(List<Object> list) {
        Appartement appartement = new Appartement((User) list.get(0),(String)list.get(1),(String)list.get(2),(Wilaya)list.get(3),(int)list.get(4),
                (Nature) list.get(5),(double)list.get(6),(boolean)list.get(7),(String)list.get(8),(String)list.get(9),(LinkedList<String>)list.get(10),
                (boolean)list.get(11),(int)list.get(12),(int)list.get(13),(int)list.get(14),(boolean)list.get(15),(Piece) list.get(16));
        CalculerPrixAppartement calculerPrixAppartement = new CalculerPrixAppartement();
        calculerPrixAppartement.calculerPrix(appartement);
        return appartement;
    }
}
