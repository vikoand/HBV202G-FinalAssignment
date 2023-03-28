package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill {

    /**
     * Observable listi af veitingarhlutum sem fara á matseðilinn
     */
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Veitingarhlutir settir í matseðilslistann
     */
    public Matsedill(){
        veitingar.add(new Veitingar("Chana masala", 2200));
        veitingar.add(new Veitingar("Brinjal", 2200));
        veitingar.add(new Veitingar("Tandoori Tikka masala", 2400));
        veitingar.add(new Veitingar("Veg masala", 2100));
        veitingar.add(new Veitingar("Naan", 450));
        veitingar.add(new Veitingar( "Samosa", 1200));

    }

    /**
     *
     * @return skilar lista af veitingum, matseðlinum
     */
    public ObservableList<Veitingar> getMatsedill(){return veitingar;}

}
