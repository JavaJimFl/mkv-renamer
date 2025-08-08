package com.kaib.media.renamer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        var fxml = new FXMLLoader(
                MainApp.class.getResource("/ui/MainView.fxml"));
        Scene scene = new Scene(fxml.load());
        stage.setTitle("MKV Renamer");
        stage.setScene(scene);
        stage.show();
        Logger.info("UI started");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
