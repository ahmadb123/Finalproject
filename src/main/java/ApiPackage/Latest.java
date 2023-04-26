
package ApiPackage;


public class Latest {
    private String name;
    private MyTeamScores[] scores;
    private LatestMatchesParticipants[] participants; 
    private int league_id;
    
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
    
    public int getLeagueId(){
        return league_id;
    }
}
