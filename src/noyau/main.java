package noyau;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main (String [] args) throws Maison_NbrEtageException, Terrain_NbrFacadesExceptions, Maison_SuperficieException, Habitable_NbrPiecesException, ObjetDejaExisterException, Appartement_NbrEtageException {
        GestionnaireBien gestionnaireBien = new GestionnaireBien();
        ArrayList<Object> list = new ArrayList<Object>();
        LinkedList<String> photos = new LinkedList<String>();
        photos.add("photo1");
        User user = new User();
        list.add(user);list.add("NumSerie");list.add("adr");list.add(Wilaya.Chlef);list.add(4);list.add(Nature.VENTE);list.add(25000.00);
        list.add(true);list.add("description");list.add("28/01/2022");list.add(photos);
        list.add(true);list.add(5);list.add(2);list.add(true);list.add(false);list.add(false);list.add(140);
        Bien b = gestionnaireBien.creerBien("Maison",list);

        System.out.println(b.getPrix() +" ** " +b.getPrixTotal());

        gestionnaireBien.insererBien(b);
        System.out.println(gestionnaireBien.getListBien());
    }
}
