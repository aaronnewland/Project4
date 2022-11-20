package com.example.project4.controllers;

import com.example.project4.enums.Flavor;
import com.example.project4.enums.Topping;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class NewYorkViewController implements Initializable {
    private ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());

    @FXML
    private ComboBox<Flavor> flavors;

    @FXML
    private ListView<Topping> toppingsList;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        flavors.getItems().addAll(Flavor.values());
        flavors.getSelectionModel().select(Flavor.BUILD_YOUR_OWN);
        toppingsList.getItems().addAll(toppings);
    }
}
