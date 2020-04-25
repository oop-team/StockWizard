package app.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class UpdateData {

    @FXML
    public void testClickButton1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("We have some info");
        alert.setContentText("I have a great message for you");
        alert.showAndWait();
    }
}
