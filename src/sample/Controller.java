package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button plotButton;

    @FXML
    private void plot(ActionEvent event) {
        event.consume();
        plotButton.setVisible(false);
        System.out.println("... and it disappeared! ");
    }
}
