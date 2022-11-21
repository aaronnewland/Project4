module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.junit.jupiter.api;

    opens com.example.project4 to javafx.fxml;
    exports com.example.project4;
    exports com.example.project4.controllers;
    opens com.example.project4.controllers to javafx.fxml;
    exports com.example.project4.flavors;
    opens com.example.project4.flavors to javafx.fxml;
    exports com.example.project4.interfaces;
    opens com.example.project4.interfaces to javafx.fxml;
    exports com.example.project4.pizzastyles;
    opens com.example.project4.pizzastyles to javafx.fxml;
    exports com.example.project4.enums;
    opens com.example.project4.enums to javafx.fxml;
}