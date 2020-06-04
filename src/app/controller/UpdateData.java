package app.controller;

import app.StockWizard;
import app.controller.helper.Mediator;
import data.Input;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateData implements Initializable {

    private File selectedFile;

    @FXML
    private Label filename;
    @FXML
    private ProgressBar updateManuallyProgressBar;
    @FXML
    private ProgressBar automaticProgressBar;
    @FXML
    private Button nextBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filename.setText("Not selected");
        nextBtn.setDisable(true);
    }

    @FXML
    private void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }

    @FXML
    private void browseData(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(StockWizard.primaryStage);
        if (selectedFile.exists()){
            filename.setText(selectedFile.getName());
        }
    }

    @FXML
    private void updateData(ActionEvent event){
        new Thread(() -> {
            Input.updateDataFromLocal(selectedFile.getAbsolutePath());
            Platform.runLater(() -> {
                updateManuallyProgressBar.setProgress(1);
                nextBtn.setDisable(false);
            });
        }).start();

        updateManuallyProgressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
    }

    @FXML
    private void downloadData(ActionEvent event) {
    	new Thread(()->  {
    		Input.updateDataFromWeb();
    		Platform.runLater(()->{
    			automaticProgressBar.setProgress(1);
    			nextBtn.setDisable(false);
    		});
    	}).start();
    	
    	automaticProgressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
    }
}
