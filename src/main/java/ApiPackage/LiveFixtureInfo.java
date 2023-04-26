package ApiPackage;

public class LiveFixtureInfo {

    private String name;
    private String starting_at;
    private ScoresInGame[] scores;
    private TeamsInfos[] participants;
    private GameEvents[] events;

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

    public GameEvents[] getGameEvents()
    {
      return events;
    }
}
