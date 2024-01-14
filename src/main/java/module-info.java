module com.branow.folder.copier {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.outfits;

    opens com.branow.fxtools.task to javafx.fxml;
    exports com.branow.fxtools;
    exports com.branow.fxtools.task;
}