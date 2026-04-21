package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Scoreboard;

public class DisplayController {

    @FXML private Label homeNameLabel;
    @FXML private Label awayNameLabel;
    @FXML private Label homeScoreLabel;
    @FXML private Label awayScoreLabel;
    @FXML private Label lastActionLabel;

    private Scoreboard model;

    public void setModel(Scoreboard model) {
        this.model = model;
    }

    public void refresh() {
        homeNameLabel.setText(model.getHomeTeamName());
        awayNameLabel.setText(model.getAwayTeamName());
        homeScoreLabel.setText(String.valueOf(model.getHomeTeamPoints()));
        awayScoreLabel.setText(String.valueOf(model.getAwayTeamPoints()));
        lastActionLabel.setText(model.getLastAction());
    }
}