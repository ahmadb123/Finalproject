
package ApiPackage;

public class RecentTransfersInfo {
    private Transfer player;
    private FromTeam fromteam;
    private ToTeam toteam;
    
    public Transfer getPlayerInfo()
    {
        return player;
    }
    
    public FromTeam getFromTeamInfo()
    {
        return fromteam;
    }
    
    public ToTeam getToTeamInfo()
    {
        return toteam;
    }
}
