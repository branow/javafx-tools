package com.branow.fxtools.task;

import com.branow.fxtools.Frame;
import com.branow.fxtools.ResourceSearcher;
import com.branow.fxtools.Stages;
import javafx.concurrent.Task;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TaskStages {


    private static final URL BAR_VIEW = ResourceSearcher.SEARCHER.fxml("task-bar-view"),
            INDICATOR_VIEW = ResourceSearcher.SEARCHER.fxml("task-indicator-view");

    public static <R> void setBarView(Stage stage, Task<R> task, String... styles) throws IOException {
        setTaskView(stage, BAR_VIEW, task, styles);
    }

    public static <R> void setIndicatorView(Stage stage, Task<R> task, String... styles) throws IOException {
        setTaskView(stage, INDICATOR_VIEW, task, styles);
    }

    public static <R> void setTaskView(Stage stage, URL url, Task<R> task, String... styles) throws IOException {
        Frame<TaskController<R>> frame = Stages.loadIntoFrame(stage, url);
        stage.getScene().getStylesheets().setAll(styles);
        frame.getController().setTask(task);
    }
}
