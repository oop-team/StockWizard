package app.controller.helper;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.Node;

public class ScreenController {
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void active(String FXMLname) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(FXMLname));
            main.setRoot(parent);
            makeFadeInEffect(parent);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void makeFadeInEffect(Node node) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    private void makeFadeOutEffect(Node node) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }
}
