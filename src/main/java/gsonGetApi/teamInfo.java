
package gsonGetApi;



public class teamInfo {
        private String image_path;
        private String name;
        private int id;
        private Player[] players;
        private Coach[] coaches;
        private Latest[] latest;
        private Latest[] upcoming;
        private Season[] seasons;
    
     public Latest[] getLatestInfo()
     {
         return latest;
     }
     public Latest[] getUpcomingInfo()
     {
         return upcoming;
     }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    public Player[] getPlayer() {
        return players;
    }

    /**
     * @return the imagePath
     */
    public String getImage_path() {
        return image_path;
    }

    public Coach[] getCoachInfo()
    {
        return coaches;
    }
    public int getTeamId()
    {
        return id;
    }
    public Season[] getSeasonsInfo()
    {
        return seasons;
    }
}
