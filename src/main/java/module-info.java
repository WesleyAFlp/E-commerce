module com.example.ecommercefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ecommercefx.controller to javafx.fxml;
    exports com.example.ecommercefx;
}