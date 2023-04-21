package hi.verkefni.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

    public class Veitingar {

        /**
         * Smiður fyrir veitingarhlut
         * @param rettur Heiti réttarinns
         * @param verd Verð réttarinns
         */
        public Veitingar(String rettur, int verd){
            setRettur(rettur);
            setVerd(verd);
        }


        public String getRettur() {
            return rettur.get();
        }

        public StringProperty retturProperty() {
            return rettur;
        }
        public void setRettur(String rettur) {
            this.rettur.set(rettur);
        }
        private final StringProperty rettur = new SimpleStringProperty();


        public int getVerd() {
            return verd.get();
        }

        public IntegerProperty verdProperty() {
            return verd;
        }
        public void setVerd(int verd) {
            this.verd.set(verd);
        }
        private final IntegerProperty verd = new SimpleIntegerProperty();


        /**
         *
         * @return Streng með heiti réttarins og verði hans
         */
        public String toString(){
        return getRettur() + "   " + getVerd() + "kr";
    }

}
