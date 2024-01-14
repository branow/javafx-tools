package com.branow.fxtools;

import javafx.stage.Stage;

public class Frame<C extends Controller> {

    private final Stage stage;
    private final C controller;

    public Frame(Stage stage, C controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public Stage getStage() {
        return stage;
    }

    public C getController() {
        return controller;
    }
}
