module com.ilyaselmabrouki.examenfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    exports com.ilyaselmabrouki.examenfinal.dao.entities;


    opens com.ilyaselmabrouki.examenfinal to javafx.fxml;
    exports com.ilyaselmabrouki.examenfinal;
}