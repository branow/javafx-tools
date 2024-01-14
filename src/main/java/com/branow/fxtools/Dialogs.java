package com.branow.fxtools;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Objects;

public class Dialogs {

    public static final String TITLE_INPUT = "Input", TITLE_CHOICE = "Choice";

    public static<T> T wait(Dialog<T> dialog) {
        return dialog.showAndWait().orElseThrow();
    }

    public static TextInputDialog input(String header, String content) {
        return input(null, TITLE_INPUT, header, content, null);
    }

    public static TextInputDialog input(String title, String header, String content) {
        return input(null, title, header, content, null);
    }

    public static TextInputDialog input(String value, String title, String header, String content) {
        return input(value, title, header, content, null);
    }

    public static TextInputDialog input(String value, String title, String header, String content, Image image) {
        if (value == null) value = "";
        TextInputDialog dialog = new TextInputDialog(value);
        fillDialog(dialog, title, header, content, image);
        return dialog;
    }

    public static<T> ChoiceDialog<T> choice(T value, Collection<T> values, String header, String content) {
        return choice(value, values, TITLE_CHOICE, header, content, null);
    }

    public static<T> ChoiceDialog<T> choice(T value, Collection<T> values, String title, String header, String content) {
        return choice(value, values, title, header, content, null);
    }

    public static<T> ChoiceDialog<T> choice(T value, Collection<T> values, String title, String header, String content, Image image) {
        Objects.requireNonNull(values);
        Objects.requireNonNull(value);
        ChoiceDialog<T> dialog = new ChoiceDialog<>(value, values);
        fillDialog(dialog, title, header, content, image);
        return dialog;
    }

    protected static<R> void fillDialog(Dialog<R> dialog, String title, String header, String content, Image image) {
        if (title != null) dialog.setTitle(title);
        if (header != null) dialog.setHeaderText(header);
        if (content != null) dialog.setContentText(content);
        if (image != null) ((Stage)dialog.getDialogPane().getScene().getWindow())
                .getIcons().add(image);
    }
}
