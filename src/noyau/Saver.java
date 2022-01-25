package noyau;

import java.io.IOException;

public abstract class Saver {

    public abstract void sauvegarder(Object o) throws IOException;
    public abstract void charger(Object p) throws IOException, ClassNotFoundException;
}
