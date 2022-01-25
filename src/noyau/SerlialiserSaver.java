package noyau;

import java.io.IOException;
import java.util.Set;

public class SerlialiserSaver extends Saver {
    private Serialiser serialiser;

    public SerlialiserSaver(Serialiser serialiser) {
        this.serialiser = serialiser;
    }

    public SerlialiserSaver() {
        this.serialiser = new Serialiser();
    }

    @Override
    public void sauvegarder(Object bien) throws IOException {
        this.serialiser.serialiser( (Set<Bien>) bien );
    }

    @Override
    public void charger(Object bien) throws IOException, ClassNotFoundException {
        this.serialiser.deserialiser( (Set<Bien>) bien);
    }
}
