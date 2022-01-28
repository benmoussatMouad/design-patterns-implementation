package noyau;

public class CalculerPrixAppartement extends CalculPrix{
    @Override
    public double fraiAjouterBien(Bien bien) {
        Appartement appartement = (Appartement) bien;
        Nature nature = bien.getTransaction();
        int etage = appartement.getEtage();
        if( nature == Nature.VENTE){
            if(etage>2) return 0 ;
            else return 50000;
        }else { // nature == location , le cas de echange n'aura jamais traite pareceque la fonction calculerPrixEchange appele CalculerPrixVente
            if(etage<=2) return 50000;
            else {
                if(etage >= 6 && !appartement.isAscenceur() ){
                    return (-1)*(500*appartement.getSuperficie());
                }else return 0 ;
            }
        }
    }
}
