package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Output {
    private SimpleStringProperty sentence;
    private CheckBox select;

    public Output() {
        select = new CheckBox();
        sentence = new SimpleStringProperty("");
    }

    public Output(String sentence) {
        select = new CheckBox();
        this.sentence = new SimpleStringProperty(sentence);
    }


    public String getSentence() {
        return sentence.get();
    }

    public void setSentence(String sentence) {
        this.sentence = new SimpleStringProperty(sentence);
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox checkBox) {
        this.select = checkBox;
    }
}
