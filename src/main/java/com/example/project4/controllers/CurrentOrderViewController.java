package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for CurrentOrderView-view.fxml
 * @author Aaron Newland, Dylan Pina
 */
public class CurrentOrderViewController implements Initializable {
    private static StoreOrdersViewController storeOrdersViewController;
    private static Order currentOrder;

    @FXML
    private TextField orderNumberTextField, subtotalTextField, salesTaxTextField, orderTotalTextField;
    @FXML
    private ListView<Pizza> currentOrderList;

    /**
     * Used when view is opened. Sets initial values and fields required for view operation.
     * @param location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resource used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        if (currentOrder == null) currentOrder = new Order();
        displayOrderNumber();
        updateCurrentOrderList();
    }

    /**
     * Action handler for remove button.
     * Allows user to remove pizzas from current order.
     */
    @FXML
    protected void handleRemovePizza() {
        Pizza pizzaToRemove = currentOrderList.getSelectionModel().getSelectedItem();
        removeFromCurrentOrder(pizzaToRemove);
        updateCurrentOrderList();
    }

    /**
     * Action handler for place order button.
     * Allows user to place their current order.
     */
    @FXML
    protected void handlePlaceOrder() {
        if (currentOrder.getOrder().isEmpty()) return;
        storeOrdersViewController.addOrder(currentOrder);
        handleClearOrder();
    }

    /**
     * Action handler for clear order button.
     * Allows user to clear all pizzas from their current order.
     */
    @FXML
    protected void handleClearOrder() {
        currentOrder = new Order();
        orderNumberTextField.setText("");
        updateCurrentOrderList();
    }

    /**
     * Links this view controller to other view controllers to pass data.
     * @param storeOrdersViewController view controller to be linked.
     */
    public void setStoreOrdersViewController(StoreOrdersViewController storeOrdersViewController) {
        this.storeOrdersViewController = storeOrdersViewController;
    }

    /**
     * Adds pizza to current order.
     * @param pizza pizza to be added to order.
     */
    public void addToCurrentOrder(Pizza pizza) {
        if (currentOrder == null) currentOrder = new Order();
        currentOrder.add(pizza);
        orderNumberTextField.setText(String.valueOf(currentOrder.getOrderNumber()));
        updateCurrentOrderList();
    }

    /**
     * Removes pizza from current order.
     * @param pizza pizza to be removed from order.
     */
    public void removeFromCurrentOrder(Pizza pizza) {
        if (pizza == null) return;
        currentOrder.remove(pizza);
        updateCurrentOrderList();
    }

    /**
     * Updates all fields in current order view when modifications are made.
     */
    private void updateCurrentOrderList() {
        clearCurrentOrderList();
        if (currentOrder == null)  {
            clearPrices();
            return;
        }
        getCalculatedPrices();
        currentOrderList.getItems().addAll(currentOrder.getOrder());
    }

    /**
     * Clears list of current orders.
     */
    private void clearCurrentOrderList() {
        if (currentOrderList.getItems() != null) currentOrderList.getItems().clear();
    }

    /**
     * Retrieves calculated prices for price fields. Sets to 2 decimal places.
     */
    private void getCalculatedPrices() {
        subtotalTextField.setText(String.format("%.2f", currentOrder.getSubtotal()));
        salesTaxTextField.setText(String.format("%.2f", currentOrder.getSalesTax()));
        orderTotalTextField.setText(String.format("%.2f", currentOrder.getOrderTotal()));
    }

    /**
     * Clears all price fields. Sets to 2 decimal places.
     */
    private void clearPrices() {
        subtotalTextField.setText(String.format("%.2f", 0.00));
        salesTaxTextField.setText(String.format("%.2f", 0.00));
        orderTotalTextField.setText(String.format("%.2f", 0.00));
    }

    /**
     * Displays order number in order number field.
     */
    private void displayOrderNumber() {
        if (currentOrder != null) orderNumberTextField.setText(String.valueOf(currentOrder.getOrderNumber()));
    }
}
