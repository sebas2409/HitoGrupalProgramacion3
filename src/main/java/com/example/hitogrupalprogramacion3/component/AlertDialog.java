package com.example.hitogrupalprogramacion3.component;

import javafx.scene.control.Alert;

public class AlertDialog {

    public static void showAlert(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
