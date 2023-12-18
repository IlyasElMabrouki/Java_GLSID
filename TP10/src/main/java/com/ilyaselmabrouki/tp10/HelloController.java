package com.ilyaselmabrouki.tp10;

import com.ilyaselmabrouki.tp10.dao.CategoryDaoImpl;
import com.ilyaselmabrouki.tp10.dao.ProductDaoImpl;
import com.ilyaselmabrouki.tp10.dao.entities.Category;
import com.ilyaselmabrouki.tp10.dao.entities.Product;
import com.ilyaselmabrouki.tp10.service.IProductService;
import com.ilyaselmabrouki.tp10.service.IServiceCategoryImpl;
import com.ilyaselmabrouki.tp10.service.IServiceProductImpl;
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
    private TableView<Product> tableProducts;

    @FXML
    private TableColumn<Integer, Product> columnID;

    @FXML
    private TableColumn<String, Product> columnNom;

    @FXML
    private TableColumn<Double, Product> columnPrix;

    @FXML
    private TableColumn<Integer, Product> columnQuantite;

    @FXML
    private TableColumn<Integer, Product> columnCategory;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldQuantite;

    @FXML
    private TextField fieldPrix;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<Category> categoryComboBox;

    ObservableList<Product> data = FXCollections.observableArrayList();

    IServiceProductImpl serviceProduct;
    IServiceCategoryImpl serviceCategory;

    //Declaration of JavaFX elements

    @FXML
    public void addProduct(){
        Product p = new Product();
        p.setName(fieldNom.getText());
        p.setPrice(Double.parseDouble(fieldPrix.getText()));
        p.setQuantity(Integer.parseInt(fieldQuantite.getText()));
        p.setCategory(serviceCategory.getCategoryByName(categoryComboBox.getValue().getName()));
        serviceProduct.addProduct(p);
        loadData();
    }

    @FXML
    public void deleteProduct(){
        tableProducts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                serviceProduct.deleteProductById(newValue.getId());
            }
        });
        loadData();
    }

    private void loadData(){
        data.clear();
        data.addAll(serviceProduct.getAllProducts());
        tableProducts.setItems(data);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Specify for each column the value
        columnID.setCellValueFactory((new PropertyValueFactory<>("id")));
        columnNom.setCellValueFactory((new PropertyValueFactory<>("name")));
        columnPrix.setCellValueFactory((new PropertyValueFactory<>("price")));
        columnQuantite.setCellValueFactory((new PropertyValueFactory<>("quantity")));
        columnCategory.setCellValueFactory((new PropertyValueFactory<>("category")));

        serviceProduct = new IServiceProductImpl(new ProductDaoImpl());
        serviceCategory = new IServiceCategoryImpl(new CategoryDaoImpl());
        loadData();
        categoryComboBox.getItems().addAll(serviceCategory.getAllCategory());
        searchField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            data.clear();
            data.addAll(serviceProduct.searchProductByQuery(newValue));
        }));
    }
}