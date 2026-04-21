package app;

import controller.DisplayController;
import controller.OperatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Scoreboard;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scoreboard model = new Scoreboard();

        FXMLLoader displayLoader = new FXMLLoader(getClass().getResource("/view/scoreboard.fxml"));
        Scene displayScene = new Scene(displayLoader.load());
        DisplayController displayController = displayLoader.getController();

        FXMLLoader controlLoader = new FXMLLoader(getClass().getResource("/view/control.fxml"));
        Scene controlScene = new Scene(controlLoader.load());
        OperatorController operatorController = controlLoader.getController();

        operatorController.setModel(model);
        operatorController.setDisplayController(displayController);
        displayController.setModel(model);

        displayScene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
        controlScene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());

        primaryStage.setTitle("Scoreboard Display");
        primaryStage.setScene(displayScene);
        primaryStage.setX(800);
        primaryStage.setY(200);
        primaryStage.show();

        Stage controlStage = new Stage();
        controlStage.setTitle("Scoreboard Operator");
        controlStage.setScene(controlScene);
        controlStage.setX(100);
        controlStage.setY(200);
        controlStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}