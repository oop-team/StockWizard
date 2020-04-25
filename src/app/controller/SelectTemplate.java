package app.controller;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectTemplate implements Initializable {

    @FXML
    private ListView listSentencesView;
    ObservableList<String> listSentences;
    private ListProperty<String> listProperty = new SimpleListProperty<String>();

    public SelectTemplate() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listSentences = FXCollections.<String>observableArrayList(
                "Tuy vậy, số mã tăng vẫn chiếm đa số.",
                "Như vậy, số mã giảm đang chiếm ưu thế.",
                "Số mã ở vùng 1-2x chiếm 60%.",
                "Số mã giảm chiếm ưu thế với 102 mã, số mã tăng chỉ 74.",
                "Số mã giảm chiếm đa số nhưng không tới mức áp đảo."
        );
        loadView();
    }

    private void loadView() {

        listSentencesView.itemsProperty().bind(listProperty);

        listSentencesView = new ListView<String>(listSentences);
//        listSentencesView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//            @Override
//            public ListCell<String> call(ListView listView) {
//                return new ListCell();
//            }
//        });
        listProperty.set(listSentences);
    }


}
