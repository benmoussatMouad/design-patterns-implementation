package noyau;

public enum Wilaya {
    Addrar(100000) , Chlef(30000) , Oumbouaki(60000);
    private int prix_Metre_Carre;

    private Wilaya(int prix)
    {
        this.prix_Metre_Carre = prix;
    }

    public int get_Prix_Metre_Carre()
    {
        return this.prix_Metre_Carre;
    }
}
