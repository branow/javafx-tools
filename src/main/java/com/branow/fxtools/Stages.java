package com.branow.fxtools;

import com.branow.outfits.checker.ParametersChecker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class Stages {

    public static Stage stage(String title, Image image) throws IOException {
        return stage(null, title, image, null, null);
    }

    public static Stage stage(String title, Image image, Window parent) throws IOException {
        return stage(null, title, image, null, parent);
    }

    public static Stage stage(String title, Image image, Scene scene) throws IOException {
        return stage(null, title, image, scene, null);
    }

    public static Stage stage(Stage stage, String title, Image image) throws IOException {
        return stage(stage, title, image, null, null);
    }

    public static Stage stage(Stage stage, String title, Image image, Window parent) throws IOException {
        return stage(stage, title, image, null, parent);
    }

    public static Stage stage(Stage stage, String title, Image image, Scene scene) throws IOException {
        return stage(stage, title, image, scene, null);
    }

    public static Stage stage(Stage stage, String title, Image image, Scene scene, Window parent) {
        if (stage == null) stage = new Stage();
        if (title != null) stage.setTitle(title);
        if (image != null) stage.getIcons().add(image);
        if (parent != null) setModality(stage, parent);
        if (scene != null) stage.setScene(scene);
        return stage;
    }


    public static<T extends Controller> Frame<T> loadIntoFrame(Stage stage, URL url) throws IOException {
        ParametersChecker.isNullThrow(url);
        ParametersChecker.isNullThrow(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        stage.setScene(new Scene(fxmlLoader.load()));
        T controller = fxmlLoader.getController();
        return new Frame<T>(stage, controller);
    }

    public static<T extends Controller> Frame<T> loadIntoFrameOn(Stage stage, URL url) throws IOException {
        T controller = (T) loadIntoFrame(stage, url).getController();
        controller.setStage(stage);
        setOnAction(stage, controller);
        return new Frame<>(stage, controller);
    }

    public static Stage loadIntoStage(Stage stage, URL url) throws IOException {
        ParametersChecker.isNullThrow(url);
        ParametersChecker.isNullThrow(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        stage.setScene(new Scene(fxmlLoader.load()));
        return stage;
    }

    public static Scene loadScene(URL url) throws IOException {
        ParametersChecker.isNullThrow(url);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        return new Scene(fxmlLoader.load());
    }


    private static void setOnAction(Stage stage, Controller controller) {
        stage.setOnCloseRequest(controller::doOnCloseRequest);
        stage.setOnShown(controller::doOnShown);
        stage.setOnHidden(controller::doOnHidden);
        stage.setOnShowing(controller::doOnShowing);
        stage.setOnHiding(controller::doOnHiding);
    }

    private static void setModality(Stage stage, Window window) {
        stage.initOwner(window);
        stage.initModality(Modality.WINDOW_MODAL);
    }

}
