package noyau;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Maison extends Habitable implements Serializable{
    //    Attributs

    private int nbrEtage ;
    private boolean garage ;
    private boolean jardin ;
    private boolean piscine ;
    private int superficieSurface ;

    public Maison(User proprietaire ,String numeroSerie, String adr, Wilaya wilaya, int superficie, Nature transaction, double prix, boolean negociable, String descriptif,String date, LinkedList<String> photos
            , boolean meuble, int nbrPiece ,int nbrEtage,boolean garage , boolean jardin , boolean piscine , int superficieSurface){
        super( proprietaire ,numeroSerie, adr, wilaya, superficie, transaction, prix, negociable, descriptif, date , photos, meuble ,nbrPiece);
        this.nbrEtage = nbrEtage ;
        this.garage = garage;
        this.jardin = jardin ;
        this.piscine = piscine ;
        setType("Maison");
        this.superficieSurface = superficieSurface ;
    }

    public Maison(){
        super();
    }
    // methodes

    // getter and setter

    public int getNbrEtage() {
        return nbrEtage;
    }

    public void setNbrEtage(int nbrEtage) {
        this.nbrEtage = nbrEtage;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public int getSuperficieSurface() {
        return superficieSurface;
    }

    public void setSuperficieSurface(int superficieSurface) {
        this.superficieSurface = superficieSurface;
    }
}
