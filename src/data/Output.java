package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import modules.SentenceGenerator;

public class Output {

    private int id;
    private CheckBox checkBox;
    private SentenceGenerator sentenceGenerator;
    private SimpleStringProperty sentence;

    public Output() {
        this.id = 0;
        this.checkBox = new CheckBox();
        this.sentence = new SimpleStringProperty("");
    }

    public Output(int id, String sentence) {
        this.id = id;
        this.checkBox = new CheckBox();
        this.sentence = new SimpleStringProperty(sentence);
    }

    public SentenceGenerator getSentenceGenerator() {
        return sentenceGenerator;
    }

    public void setSentenceGenerator(SentenceGenerator sentenceGenerator) {
        this.sentenceGenerator = sentenceGenerator;
    }

    public Output(int id, SentenceGenerator sentenceGenerator) {
        this.id = id;
        this.checkBox = new CheckBox();
        this.sentenceGenerator = sentenceGenerator;
        this.sentence = new SimpleStringProperty(sentenceGenerator.example());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence.get();
    }

    public void setSentence(String sentence) {
        this.sentence = new SimpleStringProperty(sentence);
    }

    public CheckBox getCheckBox() {
        return this.checkBox;
    }

    public void setheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public boolean getSelected() {
        return this.checkBox.isSelected();
    }
}
