package hi.verkefni.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vidskiptavinur {

    private StringProperty nafn = new SimpleStringProperty();
    public String getNafn() {
        return nafn.get();
    }
    public StringProperty nafnProperty() {
        return nafn;
    }

    public void setNafn(String nafn) {
        this.nafn.set(nafn);
    }

    /**
     * Smiður fyrir viðskiptavin
     * @param nafn viðskiptavins
     * @param heimilisf heimilisfang viðskiptavins
     */
   public Vidskiptavinur(StringProperty nafn, StringProperty heimilisf){
        this.nafn = nafn;
        this.heimilisfang = heimilisf;
   }
    private StringProperty heimilisfang = new SimpleStringProperty();

    public String getHeimilisfang() {
        return heimilisfang.get();
    }
    public StringProperty heimilisfangProperty() {
        return heimilisfang;
    }

    public void setHeimilisfang(String heimilisfang) {
        this.heimilisfang.set(heimilisfang);
    }



}
