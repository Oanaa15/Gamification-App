package com.example.gamificationaccesa;

import com.example.gamificationaccesa.controller.*;
import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {
    QuestService questservice = QuestService.getInstance();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn-view.fxml"));
        Parent root = fxmlLoader.load();
        LogInController ctrl=fxmlLoader.getController();
        Scene scene = new Scene(root, 550, 600);
        stage.setTitle("Welcomeee!!!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}