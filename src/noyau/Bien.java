package noyau;

import java.io.Serializable;
import java.util.LinkedList;
public abstract class Bien implements Comparable<Bien>, Serializable {
    //    Attributs
    private String type ;
    private User proprietaire;
    private String numeroSerie ; // nemuro unique pour chaque bien
    private String adr ;
    private Wilaya wilaya;
    private Wilaya willayaSouhaite ;
    private int superficie ;
    private Nature transaction ;
    private double prixOriginal ;
    private double prixTotal ;
    private boolean negociable ;
    private String descriptif ;
    private String date ;
    private LinkedList<String> photos ;
    private boolean archive ;

    public Bien(){

    }
    public Bien(User proprietaire,String numeroSerie , String adr , Wilaya wilaya , int superficie, Nature transaction , double prix , boolean negociable , String descriptif , String date , LinkedList<String> photos){
        this.proprietaire = proprietaire ;
        this.numeroSerie = numeroSerie ;
        this.adr = adr ;
        this.wilaya = wilaya ;
        this.superficie = superficie ;
        this.transaction = transaction ;
        this.prixOriginal =  prix ;
        this.negociable = negociable ;
        this.descriptif = descriptif ;
        this.date = date ;
        this.photos = photos ;
        this.archive = false ;
    }

//    Methodes

    // Getter and Setter
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Nature getTransaction() {
        return transaction;
    }

    public void setTransaction(Nature transaction) {
        this.transaction = transaction;
    }

    public double getPrix() {
        return prixOriginal;
    }
    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }


    public void setPrix(double prix) {
        this.prixOriginal = prix;
    }

    public boolean isNegociable() {
        return negociable;
    }

    public void setNegociable(boolean negociable) {
        this.negociable = negociable;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LinkedList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(LinkedList<String> photos) {
        this.photos = photos;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public int getPrixWilaya()
    {
        return this.wilaya.get_Prix_Metre_Carre();
    }

    public Wilaya getWillayaSouhaite() {
        return willayaSouhaite;
    }

    public void setWillayaSouhaite(Wilaya willayaSouhaite) {
        this.willayaSouhaite = willayaSouhaite;
    }




    @Override
    public int compareTo(Bien o) {
        String numero = o.getNumeroSerie();
        return this.numeroSerie.compareTo(numero);
    }

    public void ajouterPhoto(String chemin){
        this.photos.add(chemin);
    }


}
