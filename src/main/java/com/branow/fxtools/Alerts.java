package com.branow.fxtools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

import java.util.Objects;

public class Alerts {

    public static final String TITLE_INFO = "Information", TITLE_CONF = "Confirmation",
            TITLE_ERROR = "Error", TITLE_WARN = "Warning";



    public static boolean waitCancel(Alert alert) {
        return wait(alert, ButtonType.CANCEL);
    }

    public static boolean waitOK(Alert alert) {
        return wait(alert, ButtonType.OK);
    }

    public static boolean wait(Alert alert, ButtonType button) {
       return alert.showAndWait().orElseThrow() == button;
    }

    public static Alert error(Exception e) {
        return error(e, null);
    }

    public static Alert error(Exception e, Image image) {
        return alert(Alert.AlertType.ERROR, TITLE_ERROR,
                e.getClass().getSimpleName(),
                e.getMessage(),
                image);
    }

    public static Alert error(String header, String content) {
        return alert(Alert.AlertType.ERROR, TITLE_ERROR, header, content, null);
    }

    public static Alert error(String header, String content, Image image) {
        return alert(Alert.AlertType.ERROR, TITLE_ERROR, header, content, image);
    }

    public static Alert warning(String header, String content) {
        return alert(Alert.AlertType.WARNING, TITLE_WARN, header, content, null);
    }

    public static Alert warning(String header, String content, Image image) {
        return alert(Alert.AlertType.WARNING, TITLE_WARN, header, content, image);
    }

    public static Alert confirmation(String header, String content) {
        return alert(Alert.AlertType.CONFIRMATION, TITLE_CONF, header, content, null);
    }

    public static Alert confirmation(String header, String content, Image image) {
        return alert(Alert.AlertType.CONFIRMATION, TITLE_CONF, header, content, image);
    }

    public static Alert information(String header, String content) {
        return alert(Alert.AlertType.INFORMATION, TITLE_INFO, header, content, null);
    }

    public static Alert information(String header, String content, Image image) {
        return alert(Alert.AlertType.INFORMATION, TITLE_INFO, header, content, image);
    }

    public static Alert none(String header, String content) {
        return alert(Alert.AlertType.NONE, TITLE_INFO, header, content, null);
    }

    public static Alert none(String header, String content, Image image) {
        return alert(Alert.AlertType.NONE, TITLE_INFO, header, content, image);
    }

    public static Alert alert(Alert.AlertType type, String title, String header, String content) {
        return alert(type, title, header, content, null);
    }

    public static Alert alert(Alert.AlertType type, String title, String header, String content, Image image) {
        Objects.requireNonNull(type);
        Alert alert = new Alert(type);
        Dialogs.fillDialog(alert, title, header, content, image);
        return alert;
    }

}
