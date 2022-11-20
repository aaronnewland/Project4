package com.example.project4;

import com.example.project4.controllers.ChicagoViewController;
import com.example.project4.controllers.CurrentOrderViewController;
import com.example.project4.controllers.NewYorkViewController;
import com.example.project4.controllers.StoreOrdersViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PizzeriaMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzeriaMain.class.getResource("MainView-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 720);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();

        FXMLLoader storeOrdersViewLoader = new FXMLLoader(getClass().getResource("/com/example/project4/StoreOrdersView-view.fxml"));
        storeOrdersViewLoader.load();
        StoreOrdersViewController storeOrdersViewController = storeOrdersViewLoader.getController();

        FXMLLoader orderViewLoader = new FXMLLoader(getClass().getResource("/com/example/project4/CurrentOrderView-view.fxml"));
        orderViewLoader.load();
        CurrentOrderViewController orderViewController = orderViewLoader.getController();
        orderViewController.setStoreOrdersViewController(storeOrdersViewController);

        FXMLLoader chicagoLoader = new FXMLLoader(getClass().getResource("/com/example/project4/ChicagoView-view.fxml"));
        chicagoLoader.load();
        ChicagoViewController chicagoViewController = chicagoLoader.getController();
        chicagoViewController.setOrderViewController(orderViewController);

        FXMLLoader nyLoader = new FXMLLoader(getClass().getResource("/com/example/project4/NewYorkView-view.fxml"));
        nyLoader.load();
        NewYorkViewController nyViewController = nyLoader.getController();
        nyViewController.setOrderViewController(orderViewController);
    }

    public static void main(String[] args) {
        launch();
    }
}