package com.ilyaselmabrouki.examenfinal;

import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;
import com.ilyaselmabrouki.examenfinal.metier.Impl.IEntrepriseMetierImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}