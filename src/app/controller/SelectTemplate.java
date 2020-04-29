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
import modules.MaxIncreasePercent;
import modules.SentenceGenerator;
import modules.UpDownAndNotTrade;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectTemplate implements Initializable {

    private List<SentenceGenerator> modules;
    private ObservableList<Output> listSentences;
    @FXML
    private TableView tableView = new TableView();

    public SelectTemplate() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listSentences = FXCollections.<Output>observableArrayList();
        modules = new ArrayList<>();
        modules.add(new UpDownAndNotTrade());
        modules.add(new CountUpAndDown());
        modules.add(new MaxIncreasePercent());

        for (var module : modules){
            listSentences.add(new Output(module.generate()));
        }
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
