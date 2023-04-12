package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class RankingController implements Initializable {
    Long userID;

    UsersService userservice = UsersService.getInstance();


    @FXML
    TableView<User> tableView;
    @FXML
    TableColumn<User, String> tableColumnFirstName = new TableColumn<>();
    @FXML
    TableColumn<User, String> tableColumnLastName = new TableColumn<>();
    @FXML
    TableColumn<User, String> tableColumnTokens = new TableColumn<>();

    ObservableList<User> model = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tableColumnTokens.setCellValueFactory(new PropertyValueFactory<>("tokens"));

        tableView.setItems(model);
    }

    @FXML
    public void showRanking() {
        List<User> list = userservice.ranking();
        model.setAll(list);
        tableView.setItems(model);
    }
}
