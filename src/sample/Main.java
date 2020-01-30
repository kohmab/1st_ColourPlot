package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button runButton = new Button("Plot!");
        primaryStage.setTitle("Lets plot!");
        primaryStage.setScene(new Scene(root, 777, 777));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
