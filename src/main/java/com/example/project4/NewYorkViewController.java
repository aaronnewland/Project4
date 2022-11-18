package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class NewYorkViewController implements Initializable {
    private ObservableList<String> toppings = FXCollections.observableArrayList("Sausage", "BBQ_Chicken", "Beef",
            "Ham", "Pepperoni", "GreenPepper", "Onion", "Mushroom", "Pineapple", "BlackOlives",
            "Provolone", "Spinach", "Cheddar");

    //TODO: change from <String> to some kind of pizza type
    @FXML
    private ComboBox<String> flavors;

    @FXML
    private ListView<String> toppingsList;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        flavors.getItems().addAll("Build your own", "Deluxe", "BBQ Chicken", "Meatzza");
        flavors.getSelectionModel().select("Build your own");

        toppingsList.getItems().addAll(toppings);
    }
}
