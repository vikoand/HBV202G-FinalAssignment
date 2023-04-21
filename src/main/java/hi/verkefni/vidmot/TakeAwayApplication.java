package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TakeAwayApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        //Scene scene = new Scene(fxmlLoader.load(), 701, 601);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.PONTUN);
        stage.setTitle("TakeAway");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}