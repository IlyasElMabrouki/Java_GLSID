package com.ilyaselmabrouki.examenfinal;


import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;
import com.ilyaselmabrouki.examenfinal.metier.Impl.IEntrepriseMetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController2 implements Initializable {

    @FXML
    private TableView<Departement> tableDepartements;

    @FXML
    private TableColumn<Integer, Departement> columnID;

    @FXML
    private TableColumn<String, Departement> columnNom;

    @FXML
    private TableColumn<Integer, Departement> columnEntreprise;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldEntreprise;

    ObservableList<Departement> data = FXCollections.observableArrayList();

    IEntrepriseMetierImpl entrepriseMetier;

    @FXML
    public void addDepartement(){
        Departement departement = new Departement();
        departement.setNom(fieldNom.getText());
        departement.setEntreprise(entrepriseMetier.getEntreprise(Integer.parseInt(fieldEntreprise.getText())));
        entrepriseMetier.addDepartement(departement);
        loadData();
    }

    @FXML
    public void deleteDepartement(){
        tableDepartements.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                entrepriseMetier.deleteDepartement(newValue.getId());
            }
        });
        loadData();
    }

    private void loadData(){
        data.clear();
        data.addAll(entrepriseMetier.getAllDepartements());
        tableDepartements.setItems(data);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnID.setCellValueFactory((new PropertyValueFactory<>("id")));
        columnNom.setCellValueFactory((new PropertyValueFactory<>("nom")));
        columnEntreprise.setCellValueFactory((new PropertyValueFactory<>("entreprise")));
        entrepriseMetier = new IEntrepriseMetierImpl(new EntrepriseDaoImpl(), new DepartementDaoImpl(), new EmployeDaoImpl());
        loadData();
    }
}