package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import vinnsla.Karfa;
import vinnsla.Vidskiptavinur;

public class GreidslaController {

    /**
     * Reitur þar sem upplýsingar um viðskiðtavininn sem er að panta og áætlaðan afhendingartíma birtist
     */
    @FXML
    public Label skilabod;

    /**
     * Reitur þar sem upphæð pöntuninnar birtist
     */
    @FXML
    public Label tilGreidslu;
    public Label pontun;
    public Label nafn;
    public Label timi;
    public Label tilGR;
    public Label uppH;
    public Label heimilisf;

    /**
     * Tilviksbreyta af PontunController klasanum svo hægt sé að sækja aðferðir þangað
     */
    private PontunController pontunController;

    /**
     * Skilaboðin sem birtast í staðfestingarglugga
     */
    private static final String SKILABOD = "Pöntun þín hefur verið staðfest";
    private static final String ILAGI ="Í lagi";

    /**
     * Upphafsstillir og setur texta í upplýsingareitina
     */
    public void initialize(){
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        if(pontunController.vidVinur != null){
            pontun.setText("Pöntun tilbúin til afhendingar fyrir:");
            nafn.textProperty().bind(pontunController.vidVinur.nafnProperty());
            heimilisf.textProperty().bind(pontunController.vidVinur.heimilisfangProperty());
            timi.setText(" eftir " + ((int) ((Math.random()*(50-5)+5)) + " mín"));
            uppH.textProperty().bind(pontunController.fxUpphaed.textProperty());
            tilGR.setText("Til Greiðslu:");

        }
        else {
            tilGR.setText("Til Greiðslu:");
            uppH.textProperty().bind(pontunController.fxUpphaed.textProperty());
            pontun.setText("Pöntun tilbúin til afhendingar eftir: ");
            nafn.setText(((int) ((Math.random()*(50-5)+5)) + " mín"));

        }
    }
    /**
     * Hreinsar körfuna og fer með notanda aftur á pöntunarsíðu
     * @param actionEvent Ýtt er á staðfestingar hnapp
     */
    public void fxStadfestaHandler(ActionEvent actionEvent) {
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        ButtonType bType = new ButtonType(ILAGI,
                ButtonBar.ButtonData.OK_DONE);
        Alert a = stofnaAlert(bType);
        a.showAndWait();
        pontunController.hreinsa();
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Notandi fer til baka á pöntunarsíðu
     * @param actionEvent Ýtt er á til baka takk
     */
    public void onBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    private Alert stofnaAlert(ButtonType bIlagi){
        Alert alert = new Alert(Alert.AlertType.NONE, SKILABOD, bIlagi);
        alert.setTitle("Staðfesting");
        return alert;
    }


}
