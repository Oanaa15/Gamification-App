package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.io.*;

public class SignUpController {
    @FXML
    public TextField fieldSignUpFirstName;
    @FXML
    public TextField fieldSignUpLastName;
    @FXML
    public PasswordField passwordSignUp;
    @FXML
    public TextField fieldSignUpMail;

    @FXML
    public TextField fieldAge;
    @FXML
    public Button createAnAccount;

    @FXML
    public Button backToLogIn;
    @FXML
    public Label statusLogIn;
    UsersService service = UsersService.getInstance();
    private Long currentId;

//    public void setService(UsersService service) {
//        this.service = service;
//    }

    @FXML
    public void onCreateAnAccountButtonClick() throws IOException {
        Long id = service.lastid();
        String firstName = fieldSignUpFirstName.getText();
        String lastName = fieldSignUpLastName.getText();
        String mail = fieldSignUpMail.getText();
        String password = passwordSignUp.getText();
        String age = fieldAge.getText();
        int age1 = Integer.parseInt(age);
        int tokens = 0;
        String badges = "new member";
        User currentUser = new User(id, firstName, lastName, mail, age1, password, tokens,badges);
        service.add(currentUser);
        statusLogIn.setText("Connected");
    }
}

