package com.ilyaselmabrouki.examenfinal;


import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Employe;
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

public class HelloController3 implements Initializable {

    @FXML
    private TableView<Employe> tableemployes;

    @FXML
    private TableColumn<Integer, Employe> columnID;

    @FXML
    private TableColumn<String, Employe> columnNom;

    @FXML
    private TableColumn<String, Employe> columnPoste;

    @FXML
    private TableColumn<String, Employe> columnSalaire;

    @FXML
    private TableColumn<Integer, Employe> columnDepartement;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldPoste;

    @FXML
    private TextField fieldSalaire;

    @FXML
    private TextField fieldDepartement;

    ObservableList<Employe> data = FXCollections.observableArrayList();

    IEntrepriseMetierImpl entrepriseMetier;

    @FXML
    public void addEmploye(){
        Employe e = new Employe();
        e.setNom(fieldNom.getText());
        e.setPoste(fieldPoste.getText());
        e.setSalaire(Double.parseDouble(fieldSalaire.getText()));
        e.setDepartement(entrepriseMetier.getDepartement(Integer.parseInt(fieldDepartement.getText())));
        entrepriseMetier.addEmplye(e);
        loadData();
    }

    @FXML
    public void deleteEmploye(){
        tableemployes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                entrepriseMetier.deleteEmploye(newValue.getId());
            }
        });
        loadData();
    }

    private void loadData(){
        data.clear();
        data.addAll(entrepriseMetier.getAllEmployes());
        tableemployes.setItems(data);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnID.setCellValueFactory((new PropertyValueFactory<>("id")));
        columnNom.setCellValueFactory((new PropertyValueFactory<>("nom")));
        columnPoste.setCellValueFactory((new PropertyValueFactory<>("poste")));
        columnSalaire.setCellValueFactory((new PropertyValueFactory<>("salaire")));
        columnDepartement.setCellValueFactory((new PropertyValueFactory<>("departement")));
        entrepriseMetier = new IEntrepriseMetierImpl(new EntrepriseDaoImpl(), new DepartementDaoImpl(), new EmployeDaoImpl());
        loadData();
    }
}