package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


public class Controller {

    private final int W = Main.WIDTH, H = Main.HEIGHT;

    @FXML
    private Button plotButton;

    @FXML
    private void plot(ActionEvent event) {
        event.consume();
        plotButton.setVisible(false);
        final PixelWriter pw = image.getGraphicsContext2D().getPixelWriter();
        image.setHeight(H);
        image.setWidth(W);
        for (int i = 0; i < W; i++)
            for (int j = 0; j < H; j++)
                pw.setColor(i, j, colorFunction(i/W,j/H));
        System.out.println("... and it disappeared! ");

    }

    private Color colorFunction(double x, double y){
        return Color.AQUAMARINE;
    }

    @FXML
    private Canvas image = new Canvas(W,H);

}
