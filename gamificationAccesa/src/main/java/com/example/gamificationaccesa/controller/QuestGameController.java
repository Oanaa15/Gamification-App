package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class QuestGameController implements Initializable {
    Long userID;

    boolean ok = false;

    UsersService userservice = UsersService.getInstance();

    QuestService questservice = QuestService.getInstance();

    @FXML
    TableView<Quest> tableView;
    @FXML
    TableColumn<Quest, String> tableColumnName = new TableColumn<>();
    @FXML
    TableColumn<Quest, String> tableColumnSentence = new TableColumn<>();

    @FXML
    TextField questAnswer;

    @FXML
    Button submitAnswer;

    @FXML
    Label result;

    ObservableList<Quest> model = FXCollections.observableArrayList();

    int tokens;

    public void setCurrentUser(Long user) throws IOException {
        this.userID = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSentence.setCellValueFactory(new PropertyValueFactory<>("sentence"));

        ArrayList<Quest> list = questservice.getAllList();
        model.setAll(list);
        tableView.setItems(model);
    }

    public void resolveQuest(boolean ok){
        int selectedId = tableView.getSelectionModel().getSelectedIndex();
        Quest quest = tableView.getSelectionModel().getSelectedItem();

        String answer = questAnswer.getText();

        if(Objects.equals(quest.getAnswer(), answer)){
            this.ok = true;
            User user = userservice.getById(userID);
            tokens = user.getTokens() +1;
            userservice.updateTolkens(user,tokens);
            tableView.getItems().remove(selectedId);
        }
        else{
            this.ok = false;
        }
    }

    public int modifiedTokens(){
        if(ok){
            return tokens;
        }
        else{
            return userservice.getById(userID).getTokens();
        }
    }

    @FXML
    public void onSubmitAnswer(){
        resolveQuest(ok);
        if(ok){
            result.setText("Correct!");
        }
        else{
            result.setText("Please try again!");
        }
    }
}
