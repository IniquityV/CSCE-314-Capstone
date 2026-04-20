package model;

public class ScoringAction {
    private int homePoints;
    private int awayPoints;

    public ScoringAction(int homePoints, int awayPoints) {
        this.homePoints = homePoints;
        this.awayPoints = awayPoints;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public int getAwayPoints() {
        return awayPoints;
    }
}