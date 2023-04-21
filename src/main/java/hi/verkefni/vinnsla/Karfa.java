package hi.verkefni.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Karfa extends Matsedill{

    public ObservableList<Veitingar> getKarfa() {
        return karfa;
    }

    /**
     * Settir fyrir körfuna
     * @param karfa listi af veitingum sem á að fara í körfu
     */
    public void setKarfa(ObservableList<Veitingar> karfa) {
        this.karfa = karfa;
    }

    /**
     * karfan, sem er listi af veitingarhlutum
     */
    protected ObservableList<Veitingar> karfa = FXCollections.observableArrayList();

    /**
     * Setter fyrir heildarverð körfunnar
     * @param heildarverd
     */
    public void setHeildarverd(int heildarverd) {
        this.heildarverd.set(heildarverd);
    }

    /**
     * Heildarverð körfunnar
     */
    private final IntegerProperty heildarverd = new SimpleIntegerProperty();

    /**
     * @return skilar heildarverðinu
     */
    public int getHeildarverd() {
        return heildarverd.get();
    }

    /**
     *
     * @return skilar heildarverðinu sem integerProperty
     */
    public IntegerProperty heildarverdProperty() {
        return heildarverd;
    }

    /**
     * Aðferð sem fer í gegnum allar veitingarnar í körfunni, leggur saman verðið á þeim og setur sem heildarverðið
     */
    public void reiknaHeildarverd(){
        int v = 0;
        for(int i = 0; i< karfa.size(); i++){
            v += karfa.get(i).getVerd();
        }
        setHeildarverd(v);
    }


}
