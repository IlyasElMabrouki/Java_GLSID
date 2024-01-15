package com.ilyaselmabrouki.examenfinal;


import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;
import com.ilyaselmabrouki.examenfinal.metier.Impl.IEntrepriseMetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Entreprise> tableProducts;

    @FXML
    private TableColumn<Integer, Entreprise> columnID;

    @FXML
    private TableColumn<String, Entreprise> columnNom;

    @FXML
    private TableColumn<Double, Entreprise> columnAdresse;

    @FXML
    private TableColumn<Integer, Entreprise> columnTelephone;

    @FXML
    private TableColumn<Integer, Entreprise> columnEmail;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldAdresse;

    @FXML
    private TextField fieldTelephone;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField searchField;

    ObservableList<Entreprise> data = FXCollections.observableArrayList();

    IEntrepriseMetierImpl entrepriseMetier;

    //Declaration of JavaFX elements

    @FXML
    public void addEntreprise(){
        Entreprise e = new Entreprise();
        e.setNom(fieldNom.getText());
        e.setAdresse(fieldAdresse.getText());
        e.setTelephone(fieldTelephone.getText());
        e.setEmail(fieldEmail.getText());
        entrepriseMetier.addEntreprise(e);
        loadData();
    }

    @FXML
    public void deleteEntreprise(){
        tableProducts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                entrepriseMetier.deleteEntreprise(newValue.getId());
            }
        });
        loadData();
    }

    private void loadData(){
        data.clear();
        data.addAll(entrepriseMetier.getAllEntreprises());
        tableProducts.setItems(data);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Specify for each column the value
        columnID.setCellValueFactory((new PropertyValueFactory<>("id")));
        columnNom.setCellValueFactory((new PropertyValueFactory<>("nom")));
        columnAdresse.setCellValueFactory((new PropertyValueFactory<>("adresse")));
        columnTelephone.setCellValueFactory((new PropertyValueFactory<>("telephone")));
        columnEmail.setCellValueFactory((new PropertyValueFactory<>("email")));

        entrepriseMetier = new IEntrepriseMetierImpl(new EntrepriseDaoImpl(), new DepartementDaoImpl(), new EmployeDaoImpl());
        loadData();
    }
}