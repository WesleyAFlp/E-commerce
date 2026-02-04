package com.example.ecommercefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloAplication extends Application {
    public void start (Stage stage) throws Exception {
        FXMLLoader loader =new FXMLLoader(
                HelloAplication.class.getResource("/fxml/MainLayout.fxml")
        );

        Scene scene =new Scene(loader.load(), 800, 600);
        stage.setTitle("Sistema com Menu Fixo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
