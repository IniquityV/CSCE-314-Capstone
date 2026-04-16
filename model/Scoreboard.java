package model;

import java.util.Stack;

public class Scoreboard {
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamPoints;
    private int awayTeamPoints;
    private String lastAction;
    private Stack<int[]> scoreHistory;

    public Scoreboard() {
        homeTeamName = "";
        awayTeamName = "";
        homeTeamPoints = 0;
        awayTeamPoints = 0;
        lastAction = "NA";
        scoreHistory = new Stack<>();
    }

    private void validateNames(String homeName, String awayName) {
        if (homeName.isBlank() || awayName.isBlank()) {
            throw new IllegalStateException("Team names must be set before scoring");
        }
    }

    public void setTeamNames(String homeName, String awayName) {
        validateNames(homeName, awayName);
        homeTeamName = homeName;
        awayTeamName = awayName;
    }

    public void addPointsToHome(int Points) {
        validateNames(homeTeamName, awayTeamName);
        scoreHistory.push(new int[]{homeTeamPoints, awayTeamPoints});
        homeTeamPoints += Points;
        lastAction = "homeTeamName Scored: " + homeTeamPoints + " Points"; 
    }



    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public String getLastAction() {
        return lastAction;
    }
}