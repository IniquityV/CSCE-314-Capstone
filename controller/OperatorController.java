package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Scoreboard;

public class OperatorController {

    @FXML private TextField homeNameField;
    @FXML private TextField awayNameField;
    @FXML private RadioButton homeRadio;
    @FXML private RadioButton awayRadio;

    private Scoreboard model;
    private DisplayController displayController;

    public void setModel(Scoreboard model) {
        this.model = model;
    }

    public void setDisplayController(DisplayController displayController) {
        this.displayController = displayController;
    }

    @FXML
    private void handleSetNames() {
        try {
            model.setTeamNames(homeNameField.getText(), awayNameField.getText());
            displayController.refresh();
        } catch (IllegalArgumentException e) {
            showAlert(e.getMessage());
        }
    }

    @FXML private void handleTouchdown() { addPoints(6, "TD"); }
    @FXML private void handleFieldGoal()  { addPoints(3, "FG"); }
    @FXML private void handleSafety()     { addPoints(2, "SAF"); }
    @FXML private void handlePAT()        { addPoints(1, "PAT"); }

    private void addPoints(int points, String label) {
        try {
            if (homeRadio.isSelected()) {
                model.addPointsToHome(points, label);
            } else {
                model.addPointsToAway(points, label);
            }
            displayController.refresh();
        } catch (IllegalStateException e) {
            showAlert(e.getMessage());
        }
    }

    @FXML
    private void handleUndo() {
        try {
            model.undoLast();
            displayController.refresh();
        } catch (IllegalStateException e) {
            showAlert(e.getMessage());
        }
    }

    @FXML
    private void handleClear() {
        model.clearGame();
        displayController.refresh();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Action");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}