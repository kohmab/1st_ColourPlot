package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


public class Controller {

    private final double dW = Main.WIDTH, dH = Main.HEIGHT;

    @FXML
    private Button plotButton;

    @FXML
    private void plot(ActionEvent event) {
        event.consume();
        plotButton.setVisible(false);
        final PixelWriter pw = image.getGraphicsContext2D().getPixelWriter();
        image.setHeight(dH);
        image.setWidth(dW);
        for (int i = 0; i < Main.WIDTH; i++)
            for (int j = 0; j < Main.HEIGHT; j++)
                pw.setColor(i, j, colorFunction(((double) i)/dW ,((double) j)/dH));
        System.out.println("... and it disappeared! ");

    }

    private Color colorFunction(double x, double y){
        x = 2*(x-0.5);
        y = 2*(0.5-y);
        final double[] x1 =  {-0.5, 0.0, -0.5, 0.75, -0.4},
                       y1 =  {0.5, -0.5, -0.5, 0.4, -0.75}; // coordinates of the poles;
        double re = 0, im = 0;
        for (int i = 0; i < x1.length; i++) {
            double d2 = ((x - x1[i]) * (x - x1[i]) + (y - y1[i]) * (y - y1[i])); // squared distance from pole to the (x,y) point
            re += (x - x1[i]) / d2;
            im += (y - y1[i]) / d2;
        }
        return Color.hsb( 180*(Math.atan2(im,re)/Math.PI) ,1.0,1.0);
    }



    @FXML
    private Canvas image = new Canvas();

}
