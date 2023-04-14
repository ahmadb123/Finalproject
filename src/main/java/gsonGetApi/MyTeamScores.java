
package gsonGetApi;


public class MyTeamScores {
    private ScoreObject score;
    private String description;
    public ScoreObject getScore()
    {
        return score;
    }

    public String getResults(MyTeamScores[] scores) {
        if(scores == null || scores.length == 0) {
            return null; // no goals or games
        } 
        StringBuilder message = new StringBuilder();
        int homeGoalsFirstHalf = 0;
        int awayGoalsFirstHalf = 0;
        int homeGoalsSecondHalf = 0;
        int awayGoalsSecondHalf = 0;
    
        // Count home and away goals
        for (int i = 0; i < scores.length; i++) {
            if (scores[i].getScore().getGoalParticipant().equals("home")
                    && scores[i].getDescription().equals("1ST_HALF")) {
                homeGoalsFirstHalf += scores[i].getScore().getGoals();
            } else if (scores[i].getScore().getGoalParticipant().equals("away")
                    && scores[i].getDescription().equals("1ST_HALF")) {
                awayGoalsFirstHalf += scores[i].getScore().getGoals();
            } else if (scores[i].getScore().getGoalParticipant().equals("home")
                    && scores[i].getDescription().equals("2ND_HALF")) {
                homeGoalsSecondHalf += scores[i].getScore().getGoals();
            } else if (scores[i].getScore().getGoalParticipant().equals("away")
                    && scores[i].getDescription().equals("2ND_HALF")) {
                awayGoalsSecondHalf += scores[i].getScore().getGoals();
            }
        }
        // Print home and away goals for first half
        message.append("First Half: ").append(homeGoalsFirstHalf).append(" - ").append(awayGoalsFirstHalf).append("\n");
        // Print home and away goals for second half
        message.append("Second Half: ").append(homeGoalsSecondHalf).append(" - ").append(awayGoalsSecondHalf).append("\n");
        return message.toString();
    }
    
    public String getDescription()
    {
        return description;
    }
    public static int[] finalScores(MyTeamScores[] scoresInfo) {
        int homeGoals = 0;
        int awayGoals = 0;

    // Count home and away goals in the second half
    for (int i = 0; i < scoresInfo.length; i++) {
        if (scoresInfo[i].getScore().getGoalParticipant().equals("home")
                && scoresInfo[i].getDescription().equals("2ND_HALF")) {
            homeGoals += scoresInfo[i].getScore().getGoals();
        } else if (scoresInfo[i].getScore().getGoalParticipant().equals("away")
                && scoresInfo[i].getDescription().equals("2ND_HALF")) {
            awayGoals += scoresInfo[i].getScore().getGoals();
        }
    }

        return new int[]{homeGoals, awayGoals};
    }

}
