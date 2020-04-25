package app.controller;

import data.Data;
import data.Input;
import data.Output;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import modules.CountUpAndDown;
import modules.SentenceGenerator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectTemplate implements Initializable {


    private ObservableList<Output> listSentences;
    @FXML
    private TableView tableView = new TableView();

    public SelectTemplate() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Input input = new Input();
        Data exampleData = input.getExampleData();
        SentenceGenerator generator = new CountUpAndDown(exampleData);

        // TEST DATA
        listSentences = FXCollections.<Output>observableArrayList(
                new Output(generator.generate()),
                new Output(generator.generate()),
                new Output(generator.generate()),
                new Output(generator.generate()),
                new Output(generator.generate())
        );
        tableView.getItems().addAll(listSentences);
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
