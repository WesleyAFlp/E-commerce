module com.example.ecommercefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;

    opens com.example.ecommercefx.controller to javafx.fxml;
    exports com.example.ecommercefx;
}