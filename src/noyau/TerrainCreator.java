package noyau;

import java.util.LinkedList;
import java.util.List;

public class TerrainCreator extends BienCreator{
    public Bien CreerBien(List<Object> list) {
        Terrain terrain = new Terrain((User) list.get(0),(String)list.get(1),(String)list.get(2),(Wilaya)list.get(3),(int)list.get(4),
                (Nature) list.get(5),(double)list.get(6),(boolean)list.get(7),(String)list.get(8),(String)list.get(9),(java.util.LinkedList<String>)list.get(10),
                (String)list.get(11),(int)list.get(12));
        CalculerPrixTerrain calculerPrixTerrain = new CalculerPrixTerrain();
        calculerPrixTerrain.calculerPrix(terrain);
        return terrain;
    }
}
