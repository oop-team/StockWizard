package app;

import data.Input;
import data.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import data.Data;
import modules.*;

import java.io.FileNotFoundException;

public class StockWizard extends Application {

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
        primaryStage.setTitle("Stock Wizard");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws FileNotFoundException {
        //launch(args);

        new StockWizard();
    }
}
