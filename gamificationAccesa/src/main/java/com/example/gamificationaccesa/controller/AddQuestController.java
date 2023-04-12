package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.io.*;
import java.util.concurrent.*;

public class AddQuestController {
    @FXML
    TextField questName;

    @FXML
    Label result;

    @FXML
    TextField questSentence;

    @FXML
    TextField questAnswer;

    Long userID;
    UsersService userservice = UsersService.getInstance();
    QuestService questservice = QuestService.getInstance();

    @FXML
    Button addNewQuest;


    public void setCurrentUser(Long user) throws IOException {
        this.userID = user;
    }

    public void addQuest(){
        String name = questName.getText();
        String sentence = questSentence.getText();
        String answer = questAnswer.getText();
        Quest quest = new Quest(questservice.lastid(), name, userID, sentence, answer);
        questservice.add(quest);
    }

    @FXML
    public void onAddNewQuest(){
        User currentUser = userservice.getById(userID);
        if(currentUser.getTokens() > 5){
            addQuest();
            result.setText("Quest added!");
        }
        else{
            result.setText("You don't have enough tokens to add a quest!");
        }
    }


}
