package com.example.gamificationaccesa.controller;

import com.example.gamificationaccesa.*;
import com.example.gamificationaccesa.domain.*;
import com.example.gamificationaccesa.service.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;

public class LogInController {
    @FXML
    TextField fieldLogInEmail;

    @FXML
    PasswordField fieldLogInPassword;

    @FXML
    Button buttonLogIn;

    @FXML
    Button buttonSignUp;

    @FXML
    Label logIn;

    UsersService service = UsersService.getInstance();
    private Long currentId;


    public LogInController() {
    }

    @FXML
    protected void onLogInButtonClick() throws IOException {
        String mail = fieldLogInEmail.getText();
        String passwordText = fieldLogInPassword.getText();
        logIn.setText("This user doesn't exist! Please make an account!");
        //boolean ok = false;
        for (User user : service.getAll()) {
            if (Objects.equals(user.getMail(), mail) && Objects.equals(user.getPassword(), passwordText)) {
                logIn.setText("Connected successfully!");
                currentId = user.getId();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile-view.fxml"));
                Scene scene1 = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene1);
                ProfileController profileController = fxmlLoader.getController();
                profileController.setCurrentUser(currentId);
                stage.show();
            }
        }
    }

    @FXML
    protected void onSignUpButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("singUpview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        SignUpController ctrl = fxmlLoader.getController();
        stage.show();
    }
}
