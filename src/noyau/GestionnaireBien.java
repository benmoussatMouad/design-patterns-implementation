package noyau;

import java.io.Serializable;
import java.util.*;

public class GestionnaireBien implements Serializable {
    private Set<Bien> listBien  ;
    private Set<Bien> listBienArchive ;
    private BienCreator bienCreator;

    public GestionnaireBien(){
        listBien = new TreeSet<Bien>();
        listBienArchive = new TreeSet<Bien>();
    }
    public Set<Bien> getListBien(){
        return listBien;
    }
    public Bien creerBien(String type,List<Object> list) throws Maison_NbrEtageException, Terrain_NbrFacadesExceptions, Maison_SuperficieException, Habitable_NbrPiecesException, ObjetDejaExisterException, Appartement_NbrEtageException {
        if(type.equals("Maison")){
            bienCreator = new MaisonCreator();
        }else{
            if(type.equals("Appartement")){
                bienCreator = new AppartementCreator();
            }else{
                if(type.equals("Terrain")){
                    bienCreator = new TerrainCreator();
                }
            }
        }
        return bienCreator.NouveauBien(list);
    }
    public boolean insererBien(Bien b)throws ObjetDejaExisterException ,Appartement_NbrEtageException,Habitable_NbrPiecesException,Maison_NbrEtageException,Maison_SuperficieException,Terrain_NbrFacadesExceptions{

        // Si le bien s'agit d'un appartement
        if(b.getClass().getSimpleName().compareTo("Noyau.Appartement")==0)
        {
            Appartement A = (Appartement) b;
            if(A.getNbrPiece()<=0) throw new Habitable_NbrPiecesException();
            if(A.getNbrEtage()<1 || A.getNbrEtage()>2) throw new Appartement_NbrEtageException();
        }

        // Si le bien s'agit d'un maison
        if(b.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
        {
            Maison M = (Maison) b;
            if(M.getNbrPiece()<=0) throw new Habitable_NbrPiecesException();
            if(M.getNbrEtage()<=0) throw new Maison_NbrEtageException();
            if(M.getSuperficieSurface()>M.getSuperficie()) throw new Maison_SuperficieException();
        }

        // Si le bien s'agit d'un terrain
        if(b.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
        {
            Terrain T = (Terrain) b;
            if(T.getNbrFacade()<1 || T.getNbrFacade()>4) throw new Terrain_NbrFacadesExceptions();
        }

        boolean booleen;
        b.setArchive(false);
        booleen = this.listBien.add(b);
        if(booleen == false) throw new ObjetDejaExisterException() ;
        //b.getProprietaire().insererBien(b);
        return booleen;
    }
    public void supprimerBien(Bien b )
    {
        boolean var;
        var = this.listBien.remove(b);
        if(var==false)
        {
            System.out.println("Le bien que vous voulez supprimer n'existe pas dans la liste des biens");
        }
        //b.getProprietaire().supprimerBien(b);
    }
    public void archiverBien(Bien b)
    {
        this.listBienArchive.add(b);
        this.supprimerBien(b);
        b.setArchive(true);

    }
    public void modifierBien(Bien b, List<String> list_M, List<Object> list)  // list_M: contient les attributs qu'on veut changer  et list: contient leurs valeurs
    {
        for(int i=0;i<list_M.size();i++)
        {
            if(list_M.get(i).compareTo("numeroSerie")==0)
            {
                b.setNumeroSerie((String) list.get(i));
            }
            else if(list_M.get(i).compareTo("adr")==0)
            {
                b.setAdr((String) list.get(i));
            }
            else if(list_M.get(i).compareTo("wilaya")==0)
            {
                b.setWilaya((Wilaya) list.get(i));
            }
            else if(list_M.get(i).compareTo("willayaSouhaite")==0)
            {
                b.setWilaya((Wilaya) list.get(i));
            }
            else if(list_M.get(i).compareTo("superficie")==0)
            {
                b.setSuperficie((Integer)list.get(i));
            }
            else if(list_M.get(i).compareTo("transaction")==0)
            {
                b.setTransaction((Nature) list.get(i));
            }
            else if(list_M.get(i).compareTo("prixOriginal")==0)
            {
                b.setPrix((Float)list.get(i));
            }
            else if(list_M.get(i).compareTo("prixTotal")==0)
            {
                b.setPrixTotal((Float) list.get(i));
            }
            else if(list_M.get(i).compareTo("negociable")==0)
            {
                b.setNegociable((Boolean) list.get(i));
            }
            else if(list_M.get(i).compareTo("descriptif")==0)
            {
                b.setDescriptif((String)list.get(i));
            }
            else if(list_M.get(i).compareTo("photos")==0)
            {
                b.setPhotos((LinkedList<String>)list.get(i));
            }


            // pour les attribut de chaque Noyau.Bien
            // Noyau.Terrain
            if(b.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
            {
                Terrain T = (Terrain) b;
                if(list_M.get(i).compareTo("statut")==0)
                {
                    T.setStatus((String)list.get(i));
                }
                else if(list_M.get(i).compareTo("NbrFacade")==0)
                {
                    T.setNbrFacade((Integer) list.get(i));
                }
            }
            else if(b.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
            {
                Maison M = (Maison) b;
                if(list_M.get(i).compareTo("nbrPiece")==0)
                {
                    M.setNbrPiece((Integer) list.get(i));
                }
                else if(list_M.get(i).compareTo("meuble")==0)
                {
                    M.setMeuble((Boolean) list.get(i));
                }
                else if(list_M.get(i).compareTo("nbrEtage")==0)
                {
                    M.setNbrEtage((Integer) list.get(i));
                }
                else if(list_M.get(i).compareTo("garage")==0)
                {
                    M.setGarage((Boolean) list.get(i));
                }
                else if(list_M.get(i).compareTo("jardin")==0)
                {
                    M.setJardin((Boolean) list.get(i));
                }
                else if(list_M.get(i).compareTo("piscine")==0)
                {
                    M.setPiscine((Boolean) list.get(i));
                }
                else if(list_M.get(i).compareTo("superficieSurface")==0)
                {
                    M.setSuperficieSurface((Integer) list.get(i));
                }

            }
            else   // Le bien est un appartement
            {
                Appartement A = (Appartement) b;
                if(list_M.get(i).compareTo("nbrPiece")==0)
                {
                    A.setNbrPiece((Integer) list.get(i));
                }
                else if(list_M.get(i).compareTo("meuble")==0)
                {
                    A.setMeuble((Boolean) list.get(i));
                }
                else if(list_M.get(i).compareTo("Etage")==0)
                {
                    A.setEtage((Integer) list.get(i));
                }
                else if(list_M.get(i).compareTo("nbrEtage")==0)
                {
                    A.setNbrEtage((Integer) list.get(i));
                }
                else if(list_M.get(i).compareTo("ascenceur")==0)
                {
                    A.setAscenceur((Boolean) list.get(i));
                }else if(list_M.get(i).compareTo("piece")==0)
                {
                    A.setPiece((Piece) list.get(i));
                }
            }
        }
        if ( b.getTransaction() == Nature.VENTE || b.getTransaction() == Nature.ECHANGE) {
            //b.calculerPrixVente(b); //
        }else { // Noyau.Nature = location
            //b.calculerPrixLocation(b);
        }
    }
    public Set<Bien> filtrer(List<Integer> criteres,List<Object> list)
    {
        Set<Bien> List_Filtr = new TreeSet<Bien>();
        List_Filtr.addAll(this.listBien);
        Iterator<Bien> it;
        Bien B;
        int j;
        for(int i=0;i<criteres.size();i++)
        {
            j=criteres.get(i);
            switch(j)
            {
                case 1:				// type de transaction
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getTransaction()!=(Nature)list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 2:					// wilaya
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getWilaya()!=(Wilaya)list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 3:						// prix minimum
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getPrixTotal()<(Float) list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 4:					// prix maximum
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getPrixTotal()>(Float) list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 5:				// prix minimum et prix maximum
                    it = this.listBien.iterator();
                    double[] Tab = (double[])list.get(i);
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getPrixTotal()<Tab[0] || B.getPrixTotal()>Tab[1])
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 6:			//Type du bien
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo((String)list.get(i))!=0)
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 7:				//superficie minimale
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getSuperficie()<(Integer) list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 8:		  						//superficie maximale
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getSuperficie()>(Integer) list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 9:				// superficie maximale et minimale
                    it = this.listBien.iterator();
                    int[] Tab2 = (int[])list.get(i);
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getSuperficie()<Tab2[0] || B.getSuperficie()>Tab2[1])
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 10:			// nbr min de pieces
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
                        {
                            List_Filtr.remove(B);
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
                        {
                            Maison M = (Maison)B;
                            if(M.getNbrPiece()<(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")==0)
                        {
                            Appartement A = (Appartement) B;
                            if(A.getNbrPiece()<(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 11:			// nbr max de pieces
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
                        {
                            List_Filtr.remove(B);
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
                        {
                            Maison M = (Maison)B;
                            if(M.getNbrPiece()>(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")==0)
                        {
                            Appartement A = (Appartement) B;
                            if(A.getNbrPiece()>(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 12:			// nbr min et maxde pieces
                    it = this.listBien.iterator();
                    int[] Tab3 = (int[])list.get(i);
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
                        {
                            List_Filtr.remove(B);
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
                        {
                            Maison M = (Maison)B;
                            if(M.getNbrPiece()<Tab3[0] || M.getNbrPiece()>Tab3[1] )
                            {
                                List_Filtr.remove(B);
                            }
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")==0)
                        {
                            Appartement A = (Appartement) B;
                            if(A.getNbrPiece()<Tab3[0] || A.getNbrPiece()>Tab3[1] )
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 13:             // Negociable ou non
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.isNegociable()!=(Boolean) list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 14:			// meuble ou non
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")==0)
                        {
                            List_Filtr.remove(B);
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")==0)
                        {
                            Maison M = (Maison)B;
                            if(M.isMeuble()!=(Boolean) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")==0)
                        {
                            Appartement A = (Appartement) B;
                            if(A.isMeuble()!=(Boolean) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 15:		//statut
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Terrain T = (Terrain)B;
                            if(T.getStatus().compareTo((String)list.get(i))!=0)
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 16:				//prix exacte
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getPrixTotal()!=(Double)list.get(i))
                        {
                            List_Filtr.remove(B);
                        }
                    }
                    break;
                case 17:				// nbr de facade
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Terrain T2 = (Terrain) B;
                            if(T2.getNbrFacade()!=(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 18:			// nbr de facade minimale
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Terrain T3 = (Terrain) B;
                            if(T3.getNbrFacade()<(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 19:  			// nbr de facade maximale
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Terrain T3 = (Terrain) B;
                            if(T3.getNbrFacade()>(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 20:			// nbr de facade maximale
                    it = this.listBien.iterator();
                    int[] Tab4 = (int[])list.get(i);
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Terrain")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Terrain T4 = (Terrain) B;
                            if(T4.getNbrFacade()<Tab4[0] || T4.getNbrFacade()>Tab4[1] )
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 21: 		// etage ou situe un appartement
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Appartement T3 = (Appartement) B;
                            if(T3.getEtage()!=(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 22: 	// Si l'appartement s'agit d'un simplexe ou duplexe
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Appartement")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Appartement T4 = (Appartement) B;
                            if(T4.getNbrEtage()!=(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 23:			// Si la maison possede un garage
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Maison M23 = (Maison) B;
                            if(M23.isGarage()!=(Boolean) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 24:			//Si la maison possede un jardin
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Maison M24 = (Maison) B;
                            if(M24.isJardin()!=(Boolean) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 25:			// Si la maison possede une piscine
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Maison M25 = (Maison) B;
                            if(M25.isPiscine()!=(Boolean) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 26:	// Le nombre d'etage d'une maison
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Maison M26 = (Maison) B;
                            if(M26.getNbrEtage()!=(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                case 27:   // la superficie de la surface habitable
                    it = this.listBien.iterator();
                    while(it.hasNext())
                    {
                        B=it.next();
                        if(B.getClass().getSimpleName().compareTo("Noyau.Maison")!=0)
                        {
                            List_Filtr.remove(B);
                        }
                        else
                        {
                            Maison M27 = (Maison) B;
                            if(M27.getSuperficieSurface()!=(Integer) list.get(i))
                            {
                                List_Filtr.remove(B);
                            }
                        }
                    }
                    break;
                default:
                    List_Filtr.removeAll(List_Filtr);
                    break;
            }
        }
        return List_Filtr;
    }
    public Bien Recherche_Bien(String num_serie)
    {
        Bien B,tmp;
        tmp = null;
        Iterator<Bien> it_Bien = this.listBien.iterator();
        while(it_Bien.hasNext())
        {
            B = it_Bien.next();
            if(B.getNumeroSerie().compareTo(num_serie)==0)
            {
                tmp = B ;
            }
        }
        return tmp;
    }

}
