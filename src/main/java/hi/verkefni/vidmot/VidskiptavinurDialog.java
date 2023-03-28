package hi.verkefni.vidmot;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.util.Optional;

public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {
    /**
     * Reiturinn þar sem viðskiptavinur slær inn nafnið sitt
      */
    @FXML
    public TextField fxNafn;
    /**
     * Reiturinn þar sem viðskiptavinur slær inn heimilisfangið sitt
     */
    @FXML
    public TextField fxHeimilisfang;
    /**
     * Hnappurinn sem viðskiptarvinu ýtir á þegar hann hefur sett inn upplýsingarnar sínar
     */
    @FXML
    public ButtonType fxILagi;

    /**
     * Upphafsstilling, þegar í lagi hnappurinn er valinn þá er nýr viðskiptavinur búin til
     */
    public VidskiptavinurDialog(){
        setDialogPane(lesaVidskiptavinur());

        iLagiRegla();

        setResultConverter(buttonType -> {
            if(buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE){
                return new Vidskiptavinur(fxNafn.textProperty(), fxHeimilisfang.textProperty());
        } else {
                return null;
            }
        });
    }

    /**
     * Býr til dialogið fyrir innskráningu
     * @return Dialogið
     */
    private DialogPane lesaVidskiptavinur(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vidskiptavinur-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Bíður eftir upplýsingum um viðskiptavin og skilar þeim
     * @return Vidskiptavininum
     */
   public Vidskiptavinur getVidskiptavinur(){
        Optional<Vidskiptavinur> u = showAndWait();
        return u.orElse(null);
    }

    /**
     * regla þannig ekki er hægt að ýta á í lagi hnapp nema búið sé að setja upplýsingar inn í báða reiti
     */
    public void iLagiRegla(){
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty().bind(fxNafn.textProperty().isEmpty().or(fxHeimilisfang.textProperty().isEmpty()));
    }


}
