package app.controller;

import app.controller.helper.Mediator;
import model.Output;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import modules.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectSceneController implements Initializable {

    private List<SentenceGenerator> modules;

    private ObservableList<Output> listSentences;

    @FXML
    private TableView tableView = new TableView();
    @FXML
    private TableColumn<Output, String> sentenceColumn;
    @FXML
    private TableColumn<Output, Boolean> checkBoxColumn;

    private static SelectSceneController instance;

    public static SelectSceneController getInstance() {
        if (instance == null)
            return new SelectSceneController();
        return instance;
    }

    public List<SentenceGenerator> getModules() {
        return modules;
    }

    public ObservableList<Output> getListSentences() {
        return listSentences;
    }

    public SelectSceneController() {
        instance = this;
        listSentences = FXCollections.<Output>observableArrayList();
        modules = new ArrayList<>();
        modules.add(new UpDownAndNotTrade());
        modules.add(new CountUpAndDown());
        modules.add(new MaxIncreasePercent());
        modules.add(new SummaryAAV());
        modules.add(new GroupDepreciation());
        modules.add(new Liquidity());
        modules.add(new SumHNXandHSX());
        modules.add(new SumLiquidity());
        modules.add(new CountExisting());
        modules.add(new CandleStickVN30());
        modules.add(new CountMarubozu());
        int id = 0;
        for (var module : modules){
            Output output = new Output(id++, module);
            listSentences.add(output);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkBoxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxColumn));
        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        sentenceColumn.setCellValueFactory(new PropertyValueFactory<>("sentence"));

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
