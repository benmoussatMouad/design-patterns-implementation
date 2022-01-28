package noyau;

public class CalculerPrixMaison extends CalculPrix {

    @Override
    public double fraiAjouterBien(Bien bien) {
        Maison maison = (Maison) bien;
        if( maison.getTransaction() == Nature.VENTE){
            if(maison.isJardin() || maison.isPiscine() || maison.isGarage() ){
                return ((0.5)*maison.getPrix())/100;
            }
        }else {
            if(maison.isPiscine()){
                return 50000;
            }
        }
        return 0;
    }
}
