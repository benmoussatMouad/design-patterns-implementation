package noyau;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;



public class ImmoESI implements Serializable{
    private GestionnaireBien gestionnaireBien;


    private Admin admin ;

    public ImmoESI(GestionnaireBien gestionnaireBien)    //Constructeur
    {
        this.gestionnaireBien = gestionnaireBien;
    }
    public ImmoESI()
    {
        this.gestionnaireBien = new GestionnaireBien();
    }



    public boolean insererBien(Bien b)throws ObjetDejaExisterException ,Appartement_NbrEtageException,Habitable_NbrPiecesException,Maison_NbrEtageException,Maison_SuperficieException,Terrain_NbrFacadesExceptions{
        return gestionnaireBien.insererBien(b);
    }
    public void supprimerBien(Bien b )
    {
        gestionnaireBien.supprimerBien(b);
    }
    public void archiverBien(Bien b)
    {
        gestionnaireBien.archiverBien(b);
    }

    // Modifier les informations d'un bien
    public void modifierBien(Bien b,List<String> list_M,List<Object> list)  // list_M: contient les attributs qu'on veut changer  et list: contient leurs valeurs
    {
        gestionnaireBien.modifierBien( b, list_M, list );
    }


    // Filtrer les biens selon un ou plusieurs criteres
    public Set<Bien> filtrer(List<Integer> criteres,List<Object> list)
    {
        return gestionnaireBien.filtrer( criteres, list );
    }


    
    public Bien Recherche_Bien(String num_serie)
    {
        return gestionnaireBien.Recherche_Bien( num_serie );
    }

    public void sauvegarder(){

    }

    public void charger() {
        
    }
   }