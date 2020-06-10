package app.controller;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import app.StockWizard;
import app.controller.helper.Mediator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.awt.Window;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.DirectoryChooser;


public class Result implements Initializable {

    @FXML
    private TextArea resultTextArea = new TextArea();

    public Result() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String text = new String();
        for(var item : SelectTemplate.getInstance().getListSentences()) {
            text += item.getSelected() ? item.getSentenceGenerator().generate() + "\n" : "";
        }
        resultTextArea.setText(text);
    }

    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }

    @FXML
    public void save(ActionEvent event) throws IOException {
    	DirectoryChooser chooser = new DirectoryChooser();
    	chooser.setTitle("JavaFX Projects");
    	File selectedDirectory = chooser.showDialog(StockWizard.primaryStage);

    	String filePath = selectedDirectory.getAbsolutePath();
    	System.out.println(ProcessingSceneController.getInstance().getTextOutput());

        String str = ProcessingSceneController.getInstance().getTextOutput();
        FileOutputStream outputStream = new FileOutputStream(filePath+ "/result.txt");
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();

        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setContentText("Result is saved in : "+ filePath);
        alert.show();
    }
}
