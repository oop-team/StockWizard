package app.controller;

import app.StockWizard;
import app.controller.helper.Mediator;
import data.Input;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import modules.CountUpAndDown;
import modules.MaxIncreasePercent;
import modules.SentenceGenerator;
import modules.UpDownAndNotTrade;

public class UpdateData {



    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }

    @FXML
    public void browseData(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(StockWizard.primaryStage);

        Input input = new Input();
        input.updateDataFromLocal(file.getAbsolutePath());
    }

    @FXML
    public void downloadData(ActionEvent event) {

    }
}
