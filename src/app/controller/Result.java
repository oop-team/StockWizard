package app.controller;


import app.controller.helper.Mediator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import modules.SentenceGenerator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


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
    public void save(ActionEvent event) {

    }
}
