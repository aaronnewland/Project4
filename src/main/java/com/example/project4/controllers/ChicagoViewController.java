package com.example.project4.controllers;

import com.example.project4.Pizza;
import com.example.project4.enums.Crust;
import com.example.project4.enums.Flavor;
import com.example.project4.enums.Size;
import com.example.project4.enums.Topping;
import com.example.project4.interfaces.PizzaFactory;
import com.example.project4.pizzastyles.ChicagoPizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;

public class ChicagoViewController implements Initializable {
    private static CurrentOrderViewController orderViewController;
    private PizzaFactory pizzaFactory;
    private Pizza pizza;
    private ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());
    private Flavor selectedFlavor;
    private Size selectedSize;

    @FXML
    private ComboBox<Flavor> flavors;
    @FXML
    private RadioButton small, medium, large;
    @FXML
    private TextField crustTextField, priceTextField;
    @FXML
    private ListView<Topping> toppingsList, selectedToppingsList;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        flavors.getItems().addAll(Flavor.values());
        flavors.getSelectionModel().select(Flavor.BUILD_YOUR_OWN);
        selectedFlavor = flavors.getValue();
        selectedSize = Size.SMALL;
        setCrustTextField(Crust.PAN);
        toppingsList.getItems().addAll(toppings);
        pizzaFactory = new ChicagoPizza();
        pizza = pizzaFactory.createBuildYourOwn();
        setBuildYourOwn();
    }

    @FXML
    protected void handleSelectFlavor() {
        selectedFlavor = flavors.getValue();
        switch(selectedFlavor) {
            case DELUXE -> setDeluxe();
            case MEATZZA -> setMeatzza();
            case BBQ_CHICKEN -> setBBQChicken();
            case BUILD_YOUR_OWN -> setBuildYourOwn();
        }
        clearSelectedToppings();
    }

    @FXML
    protected void handleSizeChange() {
        if (small.isSelected()) this.selectedSize = Size.SMALL;
        if (medium.isSelected()) this.selectedSize = Size.MEDIUM;
        if (large.isSelected()) this.selectedSize = Size.LARGE;
        pizza.setSize(selectedSize);
        getCalculatedPrice();
    }

    @FXML
    protected void handleAddTopping() {
            if (selectedToppingsList.getItems().size() < 7) {
                Topping selectedTopping = toppingsList.getSelectionModel().getSelectedItem();
                if (selectedTopping == null) return;
                selectedToppingsList.getItems().add(selectedTopping);
                pizza.add(selectedTopping);
                toppingsList.getItems().remove(selectedTopping);
        }
        if (selectedToppingsList.getItems().size() == 7) disableToppings();
        getCalculatedPrice();
    }

    @FXML
    protected void handleRemoveTopping() {
        Topping selectedTopping = selectedToppingsList.getSelectionModel().getSelectedItem();
        if (selectedTopping == null) return;
        selectedToppingsList.getItems().remove(selectedTopping);
        pizza.remove(selectedTopping);
        toppingsList.getItems().add(selectedTopping);
        if (pizza.getToppings().size() < 7) enableToppings();
        getCalculatedPrice();
    }

    @FXML
    protected void handleAddToOrder() {
        orderViewController.addToCurrentOrder(pizza);
    }

    public void setOrderViewController(CurrentOrderViewController orderViewController) {
        this.orderViewController = orderViewController;
    }

    private void disableToppings() {
        toppingsList.setDisable(true);
    }

    private void enableToppings() { toppingsList.setDisable(false); }

    private void setDeluxe() {
        pizza = pizzaFactory.createDeluxe();
        pizza.setCrust(Crust.DEEP_DISH);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.DEEP_DISH);
        disableToppings();
        getCalculatedPrice();
    }

    private void setMeatzza() {
        pizza = pizzaFactory.createMeatzza();
        pizza.setCrust(Crust.STUFFED);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.STUFFED);
        disableToppings();
        getCalculatedPrice();
    }

    private void setBBQChicken() {
        pizza = pizzaFactory.createBBQChicken();
        pizza.setCrust(Crust.PAN);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.PAN);
        disableToppings();
        getCalculatedPrice();
    }

    private void setBuildYourOwn() {
        pizza = pizzaFactory.createBuildYourOwn();
        pizza.setCrust(Crust.PAN);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.PAN);
        enableToppings();
        getCalculatedPrice();
    }

    private void setCrustTextField(Crust crust) {
        crustTextField.setText(crust.toString());
    }

    private void clearSelectedToppings() {
        selectedToppingsList.getItems().clear();
    }

    private void getCalculatedPrice() {
        priceTextField.setText(String.format("%,.2f", pizza.price()));
    }
}
