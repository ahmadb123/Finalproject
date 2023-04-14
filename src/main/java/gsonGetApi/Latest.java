
package gsonGetApi;


public class Latest {
    private String name;
    private MyTeamScores[] scores;
    private LatestMatchesParticipants[] participants; 
    
    public String getMatchInfo(){
        return name;
    }
    
    public MyTeamScores[] getTeamScores()
    {
        return scores;
    }
    
    public LatestMatchesParticipants[] getParticipants()
    {
        return participants;
    }
}
