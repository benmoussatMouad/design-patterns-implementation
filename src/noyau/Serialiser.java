package noyau;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Serialiser {

    public void serialiser(Set<Bien> listBien) throws FileNotFoundException, IOException
    {
        String nom_Fichier = "List_Bien.txt";
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(nom_Fichier))));
        out.writeObject(listBien);
        out.close();
    }

    public void deserialiser(Set<Bien> listBien ) throws  IOException, ClassNotFoundException
    {
        String nom_Fichier = "List_Bien.txt";
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(nom_Fichier))));
        listBien.addAll((TreeSet<Bien>) in.readObject());
        in.close();
    }
}
