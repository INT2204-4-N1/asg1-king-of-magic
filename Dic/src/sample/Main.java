package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            primaryStage.setMaxHeight(600.0);
            primaryStage.setMaxWidth(600.0);
            primaryStage.setMinHeight(400.0);
            primaryStage.setMinWidth(500.0);

            Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));

            primaryStage.setTitle("Dictionary");
            primaryStage.setScene(new Scene(root, 600, 600));
            primaryStage.show();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

