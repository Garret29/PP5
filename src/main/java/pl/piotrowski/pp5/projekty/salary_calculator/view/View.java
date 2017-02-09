package pl.piotrowski.pp5.projekty.salary_calculator.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.piotrowski.pp5.projekty.salary_calculator.controller.Controller;

public class View extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view.fxml"));
        GridPane gridPane = loader.load();

        Controller controller = loader.getController();


        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setTitle("Kalkulator kosztów pracy");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
