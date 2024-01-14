package com.branow.fxtools.task;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;

public class TaskIndicator<R> extends TaskController<R> {

    @FXML
    private ProgressIndicator piProgress;

    @Override
    protected void bindProgress() {
        piProgress.progressProperty().bind(getTask().progressProperty());
    }

}
