package hi.verkefni.vidmot;

public enum View {

    PONTUN("pontun-view.fxml"),

    INNSKRANING("vidskiptavinur-view.fxml"),
    GREIDSLA("greidsla-view.fxml");



    private String filename;

    public String getFilename() {
        return filename;
    }

    View(String filename) { this.filename = filename;
    }
}
