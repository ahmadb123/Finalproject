package ApiPackage;

public class LiveFixtureInfo {

  private String name;
  private String starting_at;
  private ScoresInGame[] scores;
  private TeamsInfos[] participants;

  public ScoresInGame[] getScoresInfo() {
    return scores;
  }

  public TeamsInfos[] getParticipantsNames() {
    return participants;
  }

  public String getTeams() {
    return name;
  }
  
  public String getGameTime()
  {
      return starting_at;
  }

  public static String LiveFixtureInfo(ScoresInGame[] scoresInfo) {
    if (scoresInfo == null || scoresInfo.length == 0) {
      return null; // no goals or games
    }

    StringBuilder message = new StringBuilder();
    int homeGoalsFirstHalf = 0;
    int awayGoalsFirstHalf = 0;
    int homeGoalsSecondHalf = 0;
    int awayGoalsSecondHalf = 0;

    // Count home and away goals
    for (int i = 0; i < scoresInfo.length; i++) {
      if (
        scoresInfo[i].getScore().getParticipant().equals("home") &&
        scoresInfo[i].getGameDesc().equals("1ST_HALF")
      ) {
        homeGoalsFirstHalf += scoresInfo[i].getScore().getGoals();
      } else if (
        scoresInfo[i].getScore().getParticipant().equals("away") &&
        scoresInfo[i].getGameDesc().equals("1ST_HALF")
      ) {
        awayGoalsFirstHalf += scoresInfo[i].getScore().getGoals();
      } else if (
        scoresInfo[i].getScore().getParticipant().equals("home") &&
        scoresInfo[i].getGameDesc().equals("2ND_HALF")
      ) {
        homeGoalsSecondHalf += scoresInfo[i].getScore().getGoals();
      } else if (
        scoresInfo[i].getScore().getParticipant().equals("away") &&
        scoresInfo[i].getGameDesc().equals("2ND_HALF")
      ) {
        awayGoalsSecondHalf += scoresInfo[i].getScore().getGoals();
      }
    }

    // Print home and away goals for first half
    message
      .append("First Half: ")
      .append(homeGoalsFirstHalf)
      .append(" - ")
      .append(awayGoalsFirstHalf)
      .append("\n");

    // Print home and away goals for second half
    message
      .append("Second Half: ")
      .append(homeGoalsSecondHalf)
      .append(" - ")
      .append(awayGoalsSecondHalf)
      .append("\n");

    return message.toString();
  }

  public static int[] finalScores(ScoresInGame[] scoresInfo) {
    int homeGoals = 0;
    int awayGoals = 0;

    // Count home and away goals in the second half
    for (int i = 0; i < scoresInfo.length; i++) {
      if (
        scoresInfo[i].getScore().getParticipant().equals("home") &&
        scoresInfo[i].getGameDesc().equals("2ND_HALF")
      ) {
        homeGoals += scoresInfo[i].getScore().getGoals();
      } else if (
        scoresInfo[i].getScore().getParticipant().equals("away") &&
        scoresInfo[i].getGameDesc().equals("2ND_HALF")
      ) {
        awayGoals += scoresInfo[i].getScore().getGoals();
      }
    }

    return new int[] { homeGoals, awayGoals };
  }
}
