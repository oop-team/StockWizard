package app;

import app.controller.Mediator;
import app.controller.ScreenController;
import data.Input;
import data.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import data.Data;
import modules.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class StockWizard extends Application {

    private ScreenController screenController;

    private SentenceGenerator[] modules;

    public StockWizard() throws FileNotFoundException {
        // Get example data
        Input input = new Input();
        Data exampleData = input.getExampleData();

        // Print data
//        Session[] sessions = exampleData.getSessions();
//        for(var s : sessions){
//            System.out.println(s);
//        }

        // Test 1 module
        System.out.println("-------------------------");
        SentenceGenerator s = new CountUpAndDown(exampleData);
        System.out.println("Mẫu câu: " + s.example());
        System.out.print("Kết quả: ");
        System.out.println(s.generate());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Display GUI
        Parent root = FXMLLoader.load(getClass().getResource("view/updateData.fxml"));
        Scene scene = new Scene(root, 450, 450);

        screenController = new ScreenController(scene);

        primaryStage.setTitle("Stock Wizard");
        primaryStage.setScene(scene);
        primaryStage.show();

        Mediator.unSubcribe("onGoingUpdateData");
        Mediator.unSubcribe("onGoingSelectSentence");
        Mediator.unSubcribe("onGoingResult");
        Mediator.subcribe("onGoingUpdateData", a -> onGoingUpdateData(null));
        Mediator.subcribe("onGoingSelectSentence", a -> onGoingSelectSentence(null));
        Mediator.subcribe("onGoingResult", a -> onGoingResult(null));

    }

    public void onGoingUpdateData(ActionEvent e) {
        screenController.active("../view/updateData.fxml");
    }

    public void onGoingSelectSentence(ActionEvent e) {
        screenController.active("../view/selectTemplate.fxml");
    }

    public void onGoingResult(ActionEvent e) {
        screenController.active("../view/Result.fxml");
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
//        new StockWizard();

    }



}
