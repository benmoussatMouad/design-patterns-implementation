package noyau;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Terrain extends Bien implements Serializable{
    private String status ;
    private int nbrFacade;

    // methode
    // getter and setter

    public Terrain(User proprietaire,String numeroSerie , String adr , Wilaya wilaya , int superficie, Nature transaction , double prix , boolean negociable , String descriptif , String date, LinkedList<String> photos
            , String status, int nbrFacade ){
        super(proprietaire,numeroSerie ,adr ,wilaya ,superficie,transaction ,prix ,negociable ,descriptif,date,photos);
        this.status = status ;
        this.nbrFacade = nbrFacade ;
        setType("Terrain");
    }
    public Terrain(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbrFacade() {
        return nbrFacade;
    }

    public void setNbrFacade(int nbrFacade) {
        this.nbrFacade = nbrFacade;
    }

}
