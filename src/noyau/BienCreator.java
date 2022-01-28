package noyau;

import java.util.List;

public abstract class BienCreator {
    public abstract Bien CreerBien(List<Object> list);
    public Bien NouveauBien(List<Object> list) throws Maison_NbrEtageException, Terrain_NbrFacadesExceptions, Maison_SuperficieException, Habitable_NbrPiecesException, ObjetDejaExisterException, Appartement_NbrEtageException {
        Bien b = CreerBien(list);
        return b;
    }
}
