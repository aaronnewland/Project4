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

/**
 * Controller for ChicagoView-view.fxml
 * @author Aaron Newland, Dylan Pina
 */
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

    /**
     * Used when view is opened. Sets initial values and fields required for view operation.
     * @param location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resource used to localize the root object, or null if the root object was not localized.
     */
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

    /**
     * Action handler for the combo box of pizza flavors.
     * Allows user to select pizza flavor from combo box.
     */
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

    /**
     * Action handler for radio buttons dealing with pizza size.
     * Allows users to change the size of pizza they are ordering.
     */
    @FXML
    protected void handleSizeChange() {
        if (small.isSelected()) this.selectedSize = Size.SMALL;
        if (medium.isSelected()) this.selectedSize = Size.MEDIUM;
        if (large.isSelected()) this.selectedSize = Size.LARGE;
        pizza.setSize(selectedSize);
        getCalculatedPrice();
    }

    /**
     * Action handler for button to add pizza toppings.
     * Allows user to select up to 7 toppings to add to their build your own pizza.
     */
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

    /**
     * Action handler for button to remove pizza toppings.
     * Allows user to remove toppings from their build your own pizza.
     */
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

    /**
     * Action handler for add to order button.
     * Allows user to add current pizza to order.
     */
    @FXML
    protected void handleAddToOrder() {
        orderViewController.addToCurrentOrder(pizza);
    }

    /**
     * Links this view controller to other view controllers to pass data.
     * @param orderViewController view controller to be linked.
     */
    public void setOrderViewController(CurrentOrderViewController orderViewController) {
        this.orderViewController = orderViewController;
    }

    /**
     * Disables toppings if user has selected the max of 7 topppings.
     */
    private void disableToppings() {
        toppingsList.setDisable(true);
    }

    /**
     * Enables toppings if the user unselects toppings bringing them below 7 toppings.
     */
    private void enableToppings() { toppingsList.setDisable(false); }

    /**
     * Sets fields for Deluxe pizza as created by the pizzeria.
     */
    private void setDeluxe() {
        pizza = pizzaFactory.createDeluxe();
        pizza.setCrust(Crust.DEEP_DISH);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.DEEP_DISH);
        disableToppings();
        getCalculatedPrice();
    }

    /**
     * Sets fields for Meatzza pizza as created by the pizzeria.
     */
    private void setMeatzza() {
        pizza = pizzaFactory.createMeatzza();
        pizza.setCrust(Crust.STUFFED);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.STUFFED);
        disableToppings();
        getCalculatedPrice();
    }

    /**
     * Sets fields for BBQ Chicken pizza as created by the pizzeria.
     */
    private void setBBQChicken() {
        pizza = pizzaFactory.createBBQChicken();
        pizza.setCrust(Crust.PAN);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.PAN);
        disableToppings();
        getCalculatedPrice();
    }

    /**
     * Sets fields for Build Your Own pizza as created by the pizzeria.
     */
    private void setBuildYourOwn() {
        pizza = pizzaFactory.createBuildYourOwn();
        pizza.setCrust(Crust.PAN);
        pizza.setSize(selectedSize);
        setCrustTextField(Crust.PAN);
        enableToppings();
        getCalculatedPrice();
    }

    /**
     * Sets crust text field to required crust.
     * @param crust
     */
    private void setCrustTextField(Crust crust) {
        crustTextField.setText(crust.toString());
    }

    /**
     * Clears all selected toppings in the selected toppings list view.
     */
    private void clearSelectedToppings() {
        selectedToppingsList.getItems().clear();
    }

    /**
     * Sets text field for price of current pizza.
     */
    private void getCalculatedPrice() {
        priceTextField.setText(String.format("%,.2f", pizza.price()));
    }
}
