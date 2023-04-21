package hi.verkefni.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import hi.verkefni.vinnsla.Matsedill;

public class MatsedillView extends ListView {

    /**
     * Local hlutur fyrir matseðilinn
     */
    private Matsedill m;

    /**
     * Matseðill búin til
     */
    public MatsedillView(){
        m = new Matsedill();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        setItems(m.getMatsedill());
    }

}
