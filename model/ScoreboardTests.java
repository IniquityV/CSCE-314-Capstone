package model;

public class ScoreboardTests {
    public static void main(String[] args) {

        // Test 1: Set valid team names
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Gamecocks");
            if (sb.getHomeTeamName().equals("Aggies") && sb.getAwayTeamName().equals("Gamecocks")) {
                System.out.println("PASS: Test 1 - Valid team names set correctly");
            } else {
                System.out.println("FAIL: Test 1 - Team names not stored correctly");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 1 - Unexpected exception: " + e.getMessage());
        }

        // Test 2: Blank team names should throw exception
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("", "Gamecocks");
            System.out.println("FAIL: Test 2 - Should have thrown exception for blank name");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Test 2 - Blank name correctly rejected");
        }

        // Test 3: Add points to home and away
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToHome(6, "TD");
            sb.addPointsToAway(3, "FG");
            if (sb.getHomeTeamPoints() == 6 && sb.getAwayTeamPoints() == 3) {
                System.out.println("PASS: Test 3 - Points added correctly");
            } else {
                System.out.println("FAIL: Test 3 - Points not added correctly");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 3 - Unexpected exception: " + e.getMessage());
        }

        // Test 4: Undo after scoring should revert score
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToHome(6, "TD");
            sb.undoLast();
            if (sb.getHomeTeamPoints() == 0) {
                System.out.println("PASS: Test 4 - Undo correctly reverted home score");
            } else {
                System.out.println("FAIL: Test 4 - Undo did not revert home score");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 4 - Unexpected exception: " + e.getMessage());
        }

        // Test 5:  

        
    }
}