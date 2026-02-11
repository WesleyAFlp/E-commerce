module com.example.ecommercefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;

    opens com.example.ecommercefx to javafx.fxml;
    opens com.example.ecommercefx.controller to javafx.fxml;
    opens com.example.ecommercefx.model to javafx.base;

    exports com.example.ecommercefx;
}