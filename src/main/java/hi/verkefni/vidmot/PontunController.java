package hi.verkefni.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import vinnsla.Karfa;
import vinnsla.Matsedill;
import vinnsla.Veitingar;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.util.Optional;

public class PontunController {
    /**
     * Matseðillinn í notendaviðmótinu
     */
    @FXML
    public MatsedillView listiMatur;
    /**
     * Karfan sem eru veitingar í listview viðmótshlut
     */
    @FXML
    public ListView<Veitingar> listiKarfa;

    /**
     * Reitur þar sem upphæð pöntunnar birtist
     */
    @FXML
    public TextField fxUpphaed;
    /**
     * tilviksbreyta af Körfu klasanum
     */
    public Karfa karfan;

    /**
     * Reitur þar sem nafn innskráðs notanda birtist
     */
    @FXML
    public Label fxNotandi;

    /**
     * breytan af klasanum Vidskiptavinur sem búin er til þegar notandi skráir sig inn
     */
    public Vidskiptavinur vidVinur;

    /**
     * Takkin sem fer með notenda í greiðsluviðmót
     */
    @FXML
    public Button fxGreidaTakki;

    /**
     * Upphafsstillirm, setur í körfuna listann af hlutunum í körfunni og bindur upphæð körfunnar við textann í greiðslureitnum
     */
    public void initialize() {
        karfan = new Karfa();
        karfan.setKarfa(listiKarfa.getItems());
        fxUpphaed.textProperty().bind(karfan.heildarverdProperty().asString());
        greidaRegla();
    }

    /**
     * Valinn hlutur fjarlægður úr körfu
     * @param actionEvent Ýtt er á taka úr körfu takka
     */
    public void fxTakaUrKorfu(ActionEvent actionEvent) {
        int fjarlaegja = listiKarfa.getSelectionModel().getSelectedIndex();
        if (fjarlaegja != -1) {
            Veitingar fj = listiKarfa.getSelectionModel().getSelectedItem();
            listiKarfa.getItems().remove(fj);
            karfan.reiknaHeildarverd();
        }
    }

    /**
     * Tekur allt úr körfunni
     */
    public void hreinsa(){
        listiKarfa.getItems().removeAll();
    }

    /**
     * Valinn hlutur af matseðli settur í körfu
     * @param actionEvent Ýtt er á bæta við körfu takka
     */
    public void fxBaetaKorfuHandler (ActionEvent actionEvent){
            Veitingar v = (Veitingar) listiMatur.getSelectionModel().getSelectedItem();
            listiKarfa.getItems().add(v);
            karfan.reiknaHeildarverd();
    }

    /**
     * Dialog fyrir innskráningu birt og upplýsingar um viðskiptavin sett ó breytuna vidVinur. Nafn notandans sett í notenda reit
     * @param actionEvent Ýtt er á innskráningar hnapp
     */
    public void fxInnskraningHandler (ActionEvent actionEvent){
        VidskiptavinurDialog vidskiptavinur = new VidskiptavinurDialog();
        Vidskiptavinur vv = vidskiptavinur.getVidskiptavinur();
        vidVinur = new Vidskiptavinur(vv.nafnProperty(),vv.heimilisfangProperty());
        System.out.println("Heimilisfangið:" + vv.getHeimilisfang() + "Nafnið:" + vv.getNafn());
        fxNotandi.setText("Notandi: " + vv.getNafn());

    }

    /**
     * Notandi færður í greiðsluviðmót
     * @param actionEvent Ýtt er á greiða takka
     */
    public void fxGreidaHandler(ActionEvent actionEvent)  {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    /**
     * Leyfir notanda ekki að ýta á greiðsluhnapp nema einhvað sé komið í körfuna
     */
    public void greidaRegla(){
        fxGreidaTakki.disableProperty().bind(fxUpphaed.textProperty().isEqualTo("0"));
    }
}
