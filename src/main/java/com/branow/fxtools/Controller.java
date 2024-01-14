package com.branow.fxtools;

import com.branow.outfits.catcher.Catcher;
import com.branow.outfits.catcher.Functions;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public abstract class Controller {

    private final SimpleObjectProperty<Stage> stageProperty;

    public Controller() {
        stageProperty = new SimpleObjectProperty<>();
    }


    protected ObjectProperty<Stage> stageProperty() {
        return stageProperty;
    }

    protected Stage getStage() {
        return stageProperty.get();
    }

    protected void setStage(final Stage stage) {
        this.stageProperty.set(stage);
    }


    protected void doOnCloseRequest(WindowEvent event) {}

    protected void doOnShowing(WindowEvent event) {}

    protected void doOnShown(WindowEvent event) {}

    protected void doOnHidden(WindowEvent event) {}

    protected void doOnHiding(WindowEvent event) {}


    protected void intercept(Functions.Void func) {
        Catcher.intercept(func, this::intercept);
    }

    protected void intercept(Exception e) {
        Alerts.error(e).show();
        e.printStackTrace();
    }

}
