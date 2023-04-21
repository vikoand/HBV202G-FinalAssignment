package hi.verkefni.vinnsla;

import hi.verkefni.vidmot.PontunController;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.junit.Test;

import static org.junit.Assert.*;

public class KarfaTest {

    @Test
    public void testKarfa() {

        Karfa k = new Karfa();

        ObservableList<Veitingar> v = (ObservableList<Veitingar>) new Veitingar("Chana masala", 2200);
        k.setKarfa(v);

        assertFalse(k.getKarfa().isEmpty());


    }

    @Test
    public void testHeildarverd() {
        Karfa k = new Karfa();
        k.setHeildarverd(1200);

        assertEquals(1200, k.getHeildarverd());
    }

}