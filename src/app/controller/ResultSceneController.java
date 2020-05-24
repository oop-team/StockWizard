package app.controller;


import app.controller.helper.Mediator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


public class ResultSceneController implements Initializable {

    @FXML
    private TextArea resultTextArea = new TextArea();

    public ResultSceneController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String text = new String();
        for(var item : SelectSceneController.getInstance().getListSentences()) {
            text += item.isSelected() ? "- " + item.getSentenceGenerator().generate() + "\n" : "";
        }
        resultTextArea.setText(text);
    }

    @FXML
    public void gotoSelect(ActionEvent event) {
        Mediator.Notify("onGoingSelectSentence");
    }

    @FXML
    public void save(ActionEvent event) {

    }
}
