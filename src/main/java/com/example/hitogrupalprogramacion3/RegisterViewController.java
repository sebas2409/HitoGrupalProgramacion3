package com.example.hitogrupalprogramacion3;

import com.example.hitogrupalprogramacion3.models.User;
import com.example.hitogrupalprogramacion3.services.ApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.hitogrupalprogramacion3.component.AlertDialog.showAlert;


public class RegisterViewController {
    public TextField tfNombre;
    public Button btnCrear;



    public void createAccount() throws IOException {

        String nombre = tfNombre.getText();


        if (!nombre.isEmpty()) {
            User.globalUser = nombre;
            clearFields();
            goToLogin();
        }else {
            showAlert("Error!","Hay campos en blanco, por favor rellene todo!");
        }
    }

    public void goToLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("voting-view.fxml"));
        Stage window = (Stage) btnCrear.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void clearFields(){
        tfNombre.setText("");
    }

}
