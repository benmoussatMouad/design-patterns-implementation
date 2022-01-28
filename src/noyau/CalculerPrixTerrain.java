package noyau;

public class CalculerPrixTerrain extends CalculPrix {
    @Override
    public double fraiAjouterBien(Bien bien) {
        Terrain terrain = (Terrain) bien;
        return (terrain.getNbrFacade()-1)*(0.5*terrain.getPrix())/100;
    }
}
