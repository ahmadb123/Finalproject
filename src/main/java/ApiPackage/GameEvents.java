
package ApiPackage;

public class GameEvents {
    private String player_name;
    private ScorerDetails player;
    private String minute;
    private int type_id; // id = 14 = goal, id = 19 = yellow card
    public String getPlayerName()
    {
        return player_name;
    }
    
    public ScorerDetails getScorerInfo()
    {
        return player;
    }
    
    public String getTimeActionHappened()
    {
        return minute;
    }
    
    public int getEventId()
    {
        return type_id;
    }
}

