package noyau;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Appartement extends Habitable implements Serializable{
    //    Attributs

    private int etage;
    private Piece piece ;
    private int nbrEtage;
    private boolean ascenceur;

    public Appartement(User proprietaire ,String numeroSerie, String adr, Wilaya wilaya, int superficie, Nature transaction, double prix, boolean negociable, String descriptif, String date, LinkedList<String> photos
            , boolean meuble, int nbrPiece , int etage, int nbrEtage, boolean ascenceur , Piece piece) {
        super( proprietaire ,numeroSerie , adr, wilaya, superficie, transaction, prix, negociable, descriptif, date , photos , meuble ,nbrPiece);
        this.etage = etage;
        this.nbrEtage = nbrEtage;
        this.ascenceur = ascenceur;
        this.piece = piece;
        setType("Appartement");
    }

    public Appartement() {

    }
    // methode

    // getter and setter


    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getNbrEtage() {
        return nbrEtage;
    }

    public void setNbrEtage(int nbrEtage) {
        this.nbrEtage = nbrEtage;
    }

    public boolean isAscenceur() {
        return ascenceur;
    }

    public void setAscenceur(boolean ascenceur) {
        this.ascenceur = ascenceur;
    }
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
