package noyau;

public abstract class CalculPrix {

    public abstract double fraiAjouterBien(Bien bien);
    public void calculerPrix(Bien bien1){
        if(bien1.getTransaction().equals(Nature.VENTE)){
            this.calculerPrixVente(bien1);
        }else{
            if(bien1.getTransaction().equals(Nature.LOCATION)){
                this.calculerPrixLocation(bien1);
            }else{
                if(bien1.getTransaction().equals(Nature.ECHANGE)){
                    this.calculerPrixEchange(bien1);
                }
            }
        }
    }

    public void calculerPrixVente(Bien bien1){
        double fraisAjoutee = 0 ;

        if( bien1.getPrix() < 5000000 ){
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (3*bien1.getPrix())/100 ;

            }else{
                fraisAjoutee = (3.5*bien1.getPrix())/100 ;
            }

        }else if( bien1.getPrix() >= 5000000 && bien1.getPrix() <= 15000000){
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (2*bien1.getPrix())/100 ;
            }else{
                fraisAjoutee = (2.5*bien1.getPrix())/100 ;
            }
        }else { // if( getPrix() >= 150000)
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (1*bien1.getPrix())/100 ;
            }else{
                fraisAjoutee = (2*bien1.getPrix())/100 ;
            }
        }

        bien1.setPrixTotal((float) (bien1.getPrix() + fraisAjoutee + this.fraiAjouterBien(bien1)));
    }
    public void calculerPrixLocation(Bien bien1){

        double fraisAjoutee = 0 ;

        if ( bien1.getSuperficie() < 60 ){
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (1*bien1.getPrix())/100 ;
            }else{
                fraisAjoutee = (1.5*bien1.getPrix())/100 ;
            }
        }else if( bien1.getSuperficie()>= 60 && bien1.getSuperficie() <= 150 ){
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (2*bien1.getPrix())/100 ;
            }else{
                fraisAjoutee = (2.5*bien1.getPrix())/100 ;
            }
        }else if(bien1.getSuperficie() > 150 ){
            if( bien1.getPrixWilaya() < 50000 ){
                fraisAjoutee = (3*bien1.getPrix())/100 ;
            }else{
                fraisAjoutee = (3.5*bien1.getPrix())/100 ;
            }
        }
        bien1.setPrixTotal((float) (bien1.getPrix() + fraisAjoutee + fraiAjouterBien(bien1)));

    }
    public void calculerPrixEchange(Bien bien1){
        if( bien1.getWilaya() != bien1.getWillayaSouhaite() ){
            bien1.setPrixTotal((float) (bien1.getPrixTotal() + (0.25*bien1.getPrix())/100));
        }

    }
}
