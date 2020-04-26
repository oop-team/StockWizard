package app.controller;


import app.controller.helper.Mediator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Result {
    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }
    @FXML
    public void save(ActionEvent event) {
        
    }
}
