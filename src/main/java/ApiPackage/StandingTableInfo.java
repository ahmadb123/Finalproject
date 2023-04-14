
package ApiPackage;

public class StandingTableInfo {
    private int position;
    private int points;
    private Participant participant;
    private int season_id;
    
    public int getPosition()
    {
        return position;
    }
    public int getPoints()
    {
        return points;
    }
    public Participant getTeamInfo()
    {
        return participant;
    }
    public int getSeasonId()
    {
        return season_id;
    }
}
