
package gsonGetApi;


public class LiveFixtureInfo {
    private String name;
    private String starting_at;
    private ScoresInGame[] scores;
    private TeamsInfos[] participants;
    
    public ScoresInGame[] getScoresInfo()
    {
        return scores;
    }
    public TeamsInfos[] getParticipantsNames()
    {
        return participants;
    }
    public String getTeams()
    {
        return name;
    }
}
