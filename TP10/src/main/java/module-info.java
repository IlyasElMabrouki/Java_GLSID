module com.ilyaselmabrouki.tp10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    exports com.ilyaselmabrouki.tp10.dao.entities;

    opens com.ilyaselmabrouki.tp10 to javafx.fxml;
    exports com.ilyaselmabrouki.tp10;
}