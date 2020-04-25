package app.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Result {
    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }
}
