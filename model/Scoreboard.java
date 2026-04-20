package model;

import java.util.Stack;

public class Scoreboard {
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamPoints;
    private int awayTeamPoints;
    private String lastAction;
    private Stack<ScoringAction> scoreHistory;

    public Scoreboard() {
        homeTeamName = "";
        awayTeamName = "";
        homeTeamPoints = 0;
        awayTeamPoints = 0;
        lastAction = "NA";
        scoreHistory = new Stack<>();
    }

    private void validateNames() {
        if (homeTeamName.isBlank() || awayTeamName.isBlank()) {
            throw new IllegalStateException("Team names must be set before scoring!");
        }
    }

    public void setTeamNames(String homeName, String awayName) {
        if (homeName.isBlank() || awayName.isBlank()) {
            throw new IllegalArgumentException("Invalid: Team names must be set!");
        }
        homeTeamName = homeName;
        awayTeamName = awayName;
    }

    public void addPointsToHome(int points, String actionLabel) {
        validateNames();
        scoreHistory.push(new ScoringAction(homeTeamPoints, awayTeamPoints));
        homeTeamPoints += points;
        lastAction = homeTeamName + " +" + points + " (" + actionLabel + ")";
    }

    public void addPointsToAway(int points, String actionLabel) {
        validateNames();
        scoreHistory.push(new ScoringAction(homeTeamPoints, awayTeamPoints));
        awayTeamPoints += points;
        lastAction = awayTeamName + " +" + points + " (" + actionLabel + ")";
    }

    public void undoLast() {
        if (scoreHistory.isEmpty()) {
            throw new IllegalStateException("There is no last action!");
        }
        ScoringAction last = scoreHistory.pop();
        homeTeamPoints = last.getHomePoints();
        awayTeamPoints = last.getAwayPoints();
        lastAction = "Undo performed";
    }

    public void clearGame() {
        homeTeamPoints = 0;
        awayTeamPoints = 0;
        scoreHistory.clear();
        lastAction = "Game cleared";
    }

    public String getHomeTeamName() { return homeTeamName; }
    public String getAwayTeamName() { return awayTeamName; }
    public int getHomeTeamPoints()  { return homeTeamPoints; }
    public int getAwayTeamPoints()  { return awayTeamPoints; }
    public String getLastAction()   { return lastAction; }
}