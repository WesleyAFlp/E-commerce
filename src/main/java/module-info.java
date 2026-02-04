module com.example.ecommercefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ecommercefx.controller to javafx.fxml;
    exports com.example.ecommercefx;
}