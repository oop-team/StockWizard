package app.controller;

import app.controller.helper.Mediator;
import data.Data;
import data.Input;
import data.Output;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modules.CountUpAndDown;
import modules.SentenceGenerator;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectTemplate implements Initializable {


    private ObservableList<Output> listSentences;
    @FXML
    private TableView tableView = new TableView();

    public SelectTemplate() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Input input = new Input();
//        Data exampleData = input.getExampleData();
//        SentenceGenerator generator = new CountUpAndDown(exampleData);
//
//        // TEST DATA
//        listSentences = FXCollections.<Output>observableArrayList(
//                new Output(generator.example()),
//                new Output(generator.example()),
//                new Output(generator.example()),
//                new Output(generator.example()),
//                new Output(generator.example())
//        );
//        tableView.getItems().addAll(listSentences);
    }

    @FXML
    public void gotoUpdate(ActionEvent event) {
        Mediator.Notify("onGoingUpdateData");
    }
    @FXML
    public void gotoResult(ActionEvent event) {
        Mediator.Notify("onGoingResult");
    }
}
