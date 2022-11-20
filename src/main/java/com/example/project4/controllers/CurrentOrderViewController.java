package com.example.project4.controllers;

import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CurrentOrderViewController implements Initializable{
    private static int orderNumber;
    private ArrayList<Pizza> currentOrder;
    private double subtotal;
    private double salesTax;
    private static final double njSalesTaxPercentage = 6.625;
    private double orderTotal;

    @FXML
    private TextField orderNumberTextField, subtotalTextField, salesTaxTextField, orderTotalTextField;
    @FXML
    private ListView<Pizza> currentOrderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentOrder = new ArrayList<>();
        subtotal = 0;
        salesTax = 0;
        orderTotal = 0;
    }

    @FXML
    protected void handleRemovePizza() {

    }

    @FXML
    protected void handlePlaceOrder() {

    }

    @FXML
    protected void handleClearOrder() {
        currentOrder.clear();
        getCalculatedPrice();
    }

    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.add(pizza);
        orderNumber += 1;
        System.out.println(pizza);
    }

    public void removeFromCurrentOrder(Pizza pizza) {
        if (currentOrder.contains(pizza)) currentOrder.remove(pizza);
        getCalculatedPrice();
    }

    private void getCalculatedPrice() {
        subtotal = 0;
        for (Pizza x : currentOrder)  subtotal += x.price();
        salesTax = subtotal * njSalesTaxPercentage;
        orderTotal = subtotal + salesTax;
    }
}
