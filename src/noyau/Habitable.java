package noyau;
import java.io.Serializable;
import java.util.LinkedList;

public abstract class Habitable extends Bien implements Serializable{
    //    Attributs
    private int nbrPiece ;
    private boolean meuble ;

    public Habitable(User proprietaire , String numeroSerie , String adr , Wilaya wilaya , int superficie, Nature transaction , double prix , boolean negociable , String descriptif , String date , LinkedList<String> photos , boolean meuble , int nbrPiece){
        super(proprietaire,numeroSerie ,adr ,wilaya ,superficie,transaction ,prix ,negociable ,descriptif ,date,photos);
        this.meuble = meuble ;
        this.nbrPiece = nbrPiece;
    }

    public Habitable() {

    }
//    methodes


    // Getter and Setter
    public int getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(int nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    public boolean isMeuble() {
        return meuble;
    }

    public void setMeuble(boolean meuble) {
        this.meuble = meuble;
    }

}
