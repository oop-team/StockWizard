package app;

import app.controller.helper.Mediator;
import app.controller.helper.ScreenController;
import data.Input;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import data.Data;
import modules.*;
import utilities.CandleStick;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StockWizard extends Application {

    public static Stage primaryStage;

    private ScreenController screenController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Display GUI
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("view/updateData.fxml"));
        Scene scene = new Scene(root, 450, 450);

        screenController = new ScreenController(scene);

        primaryStage.setTitle("Stock Wizard");
        primaryStage.setScene(scene);
        primaryStage.show();

        Mediator.unSubscribe("onGoingUpdateData");
        Mediator.unSubscribe("onGoingSelectSentence");
        Mediator.unSubscribe("onGoingResult");
        Mediator.subscribe("onGoingUpdateData", a -> onGoingUpdateData(null));
        Mediator.subscribe("onGoingSelectSentence", a -> onGoingSelectSentence(null));
        Mediator.subscribe("onGoingResult", a -> onGoingResult(null));
    }

    public void onGoingUpdateData(ActionEvent e) {
        screenController.active("../../view/updateData.fxml");
    }

    public void onGoingSelectSentence(ActionEvent e) {
        screenController.active("../../view/selectTemplate.fxml");
    }

    public void onGoingResult(ActionEvent e) {
        screenController.active("../../view/Result.fxml");
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }



}
