package app.controller;

import app.controller.helper.Mediator;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class UpdateData {

    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }

}
