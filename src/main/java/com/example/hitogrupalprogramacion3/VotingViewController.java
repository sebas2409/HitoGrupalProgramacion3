package com.example.hitogrupalprogramacion3;

import com.example.hitogrupalprogramacion3.models.User;
import com.example.hitogrupalprogramacion3.models.Votation;
import com.example.hitogrupalprogramacion3.services.ApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.hitogrupalprogramacion3.component.AlertDialog.showAlert;

public class VotingViewController implements Initializable {

    public Button btnShowAll;
    public Label lblVulne;
    public Label lblRend;
    public Label lblCE;
    public Label lblEst;
    public Label lblFunc;
    public Label lblVotosTotales;
    ObservableList<Integer> valor = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    ApiService apiService = new ApiService();
    public ComboBox cbEstetica;
    public ComboBox cbFuncionalidad;
    public ComboBox cbVulnerabilidad;
    public ComboBox cbControlErrores;
    public ComboBox cbRendimiento;
    public Button btnSendVotacion;


    public void sendVotes() throws UnirestException {

        int este = (int) cbEstetica.getValue();
        int funci = (int) cbFuncionalidad.getValue();
        int vulne = (int) cbVulnerabilidad.getValue();
        int rendi = (int) cbRendimiento.getValue();
        int contr = (int) cbControlErrores.getValue();

        User user = new User(User.globalUser);
        Votation votation = new Votation(user,este,vulne,funci,contr,rendi);

        apiService.sendVote(votation);
        showAlert("Exito!","Gracias por realizar esta votacion!");
        Stage stage = (Stage) btnSendVotacion.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbEstetica.setItems(valor);
        cbFuncionalidad.setItems(valor);
        cbControlErrores.setItems(valor);
        cbVulnerabilidad.setItems(valor);
        cbRendimiento.setItems(valor);
    }

    public void showVotations() throws UnirestException {
        apiService.getVotes();
        lblCE.setText(ApiService.getMedia(ApiService.listaCE));
        lblEst.setText(ApiService.getMedia(ApiService.listaEst));
        lblRend.setText(ApiService.getMedia(ApiService.listaRendi));
        lblFunc.setText(ApiService.getMedia(ApiService.listaFunci));
        lblVulne.setText(ApiService.getMedia(ApiService.listaVulne));
        lblVotosTotales.setText(String.valueOf(ApiService.listaCE.size()));
    }
}
