package app;

import app.controller.helper.Mediator;
import app.controller.helper.ScreenController;
import data.Input;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import data.Data;
import modules.*;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StockWizard extends Application {

    private ScreenController screenController;

    private List<SentenceGenerator> modules;

    public StockWizard() throws FileNotFoundException {
        Input input = new Input();
        input.updateDataFromLocal("res/sample data/CafeF.SolieuGD.Upto27042020.zip");

        // Init modules
        modules = new ArrayList<>();
        modules.add(new UpDownAndNotTrade());
        modules.add(new CountUpAndDown());
        modules.add(new MaxIncreasePercent());

        for (var m : modules){
            System.out.println("-------------------------");
            System.out.println("Module: " + m.getClass().getName());
            System.out.println("Mẫu câu: " + m.example());
            System.out.print("Kết quả: ");
            System.out.println(m.generate());
        }

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
//        launch(args);
        new StockWizard();

    }



}
