package com.github.juhachmann;

import atlantafx.base.theme.NordDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImcApplication extends Application {

    static Scene scene;

    public static boolean darkMode = true;

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());
        stage.setTitle("Saúde Não Se Pesa!");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) {
        var fxmlLoader = new FXMLLoader(ImcApplication.class.getResource(fxml));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)  {
        String startingScene = "view/input-scene.fxml";
        scene = new Scene(loadFXML(startingScene), 440, 640);
        launch();
    }

}