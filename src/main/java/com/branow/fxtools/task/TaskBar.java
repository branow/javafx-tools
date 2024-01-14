package com.branow.fxtools.task;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class TaskBar<R> extends TaskController<R> {

    @FXML
    private ProgressBar pbProgress;

    @Override
    protected void bindProgress() {
        pbProgress.progressProperty().bind(getTask().progressProperty());
    }

}
