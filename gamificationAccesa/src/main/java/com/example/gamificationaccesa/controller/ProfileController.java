package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.*;
import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;

public class ProfileController {
    @FXML
    Button signOut;
    @FXML
    Label profileFirstName;
    @FXML
    Label profileSecondName;
    @FXML
    Label profileMail;

    @FXML
    Label profileTokens;

    @FXML
    Label profileBadges;

    Long userID;
    UsersService service = UsersService.getInstance();
    private Scene scene;

    @FXML
    TableView<User> ranking;

    @FXML
    Button addQuest;

    @FXML
    Button showRanking;

    @FXML
    Button solveQuests;


    @FXML
    private void setData() {
        profileFirstName.setText(service.getById(userID).getFirstname());
        profileSecondName.setText(service.getById(userID).getLastname());
        profileMail.setText(service.getById(userID).getMail());
        int numberofTokens = service.getById(userID).getTokens();
        profileTokens.setText("Tokens: " + numberofTokens);
        profileBadges.setText(service.getById(userID).getBadges());
    }


    public void setCurrentUser(Long user) throws IOException {
        this.userID = user;
        setData();
    }

    @FXML
    protected void onAddQuest() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addquestview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        AddQuestController ctrl = fxmlLoader.getController();
        ctrl.setCurrentUser(userID);
        stage.show();
    }

    public void onSignOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logIn-view.fxml"));
        Parent root = fxmlLoader.load();
        LogInController ctrl = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 550, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void onShowRanking(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rankingview.fxml"));
        Parent root = fxmlLoader.load();
        RankingController ctrl = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 550, 600);
        stage.setScene(scene);
        ctrl.showRanking();
        stage.show();
    }

    public void onSolveQuests(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("solvequests.fxml"));
        Parent root = fxmlLoader.load();
        QuestGameController ctrl = fxmlLoader.getController();
        ctrl.setCurrentUser(userID);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 550, 600);
        stage.setScene(scene);
        stage.show();
        int tokens = ctrl.modifiedTokens();
        profileTokens.setText("Tokens: " + tokens);
    }
}
