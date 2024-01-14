package com.branow.fxtools.task;

import javafx.beans.binding.When;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public abstract class TaskController<R> {

    @FXML
    private Label lMessage, lTitle, lException;
    @FXML
    private TextArea taResult;
    @FXML
    private Button bStart, bCancel;

    private Task<R> task;

    protected abstract void bindProgress();

    public void bStartAction() {
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public void bCancelAction() {
        task.cancel();
    }

    public void setTask(Task<R> task) {
        this.task = task;
        bindTask();
    }

    public Task<R> getTask() {
        return task;
    }

    private void bindTask() {
        lTitle.textProperty().bind(task.titleProperty());
        lMessage.textProperty().bind(task.messageProperty());
        lException.textProperty().bind(
                new When(task.exceptionProperty().isNotNull())
                        .then(task.exceptionProperty().asString())
                        .otherwise(""));
        taResult.textProperty().bind(
                new When(task.valueProperty().isNotNull())
                        .then(task.valueProperty().asString())
                        .otherwise(""));
        bStart.disableProperty().bind(task.stateProperty().isNotEqualTo(Worker.State.READY));
        bCancel.disableProperty().bind(task.runningProperty().not());
        bindProgress();
    }



}
