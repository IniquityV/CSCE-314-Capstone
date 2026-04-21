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
            if (sb.getHomeTeamPoints() == 0 && sb.getAwayTeamPoints() == 0) {
                System.out.println("PASS: Test 4 - Undo correctly reverted home score");
            } else {
                System.out.println("FAIL: Test 4 - Undo did not revert home score");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 4 - Unexpected exception: " + e.getMessage());
        }

        // Test 5: Undoing with no added points throws an exception
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.undoLast();
            System.out.println("FAIL: Test 5 - Should have thrown exception for undoing last action");
        } catch (IllegalStateException e) {
            System.out.println("PASS: Test 5 - Empty undo correctly threw exception");
        }

        // Test 6: Clear game resets scores but preserves team names
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToAway(6, "TD");
            sb.addPointsToHome(6, "TD");
            sb.clearGame();
            if (sb.getHomeTeamPoints() == 0 && sb.getAwayTeamPoints() == 0
                    && sb.getLastAction().equals("NA")
                    && sb.getHomeTeamName().equals("Aggies")) {
                System.out.println("PASS: Test 6 - Game correctly cleared, names preserved");
            } else {
                System.out.println("FAIL: Test 6 - Game not correctly cleared");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 6 - Unexpected exception: " + e.getMessage());
        }

        // Test 7: Scoring before setting a name
        try {
            Scoreboard sb = new Scoreboard();
            sb.addPointsToAway(6, "TD");
            System.out.println("FAIL: Test 7 - Should have thrown exception for scoring without names");
        } catch (IllegalStateException e) {
            System.out.println("PASS: Test 7 - Correctly throws exception for scoring without names");
        }

        // Test 8: Last action updates correctly after scoring
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToHome(6, "TD");
            sb.addPointsToAway(6, "TD");
            if (sb.getLastAction().equals("Texas +6 (TD)")) {
                System.out.println("PASS: Test 8 - Last action updated correctly");
            } else {
                System.out.println("FAIL: Test 8 - Last action not updated correctly");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 8 - Unexpected exception: " + e.getMessage());
        }

        // Test 9: Undo after clear game should throw exception
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToHome(6, "TD");
            sb.clearGame();
            sb.undoLast();
            System.out.println("FAIL: Test 9 - Should have thrown exception for undoing after clear");
        } catch (IllegalStateException e) {
            System.out.println("PASS: Test 9 - Undo after clear correctly threw exception");
        }

        // Test 10: Last action updates correctly after undo
        try {
            Scoreboard sb = new Scoreboard();
            sb.setTeamNames("Aggies", "Texas");
            sb.addPointsToHome(6, "TD");
            sb.undoLast();
            if (sb.getLastAction().equals("Undo performed")) {
                System.out.println("PASS: Test 10 - Last action correctly updated after undo");
            } else {
                System.out.println("FAIL: Test 10 - Last action not updated after undo");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Test 10 - Unexpected exception: " + e.getMessage());
        }
    }
}