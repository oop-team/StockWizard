package app.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ScreenController {
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void active(String FXMLname) {
        try {
            main.setRoot(FXMLLoader.load(getClass().getResource(FXMLname)));
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
