
package ApiPackage;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StandingTableApi {
    
    public StandingTableInfo[] data;
    
    public static StandingTableApi getTable(int leagueId, int teamId) {
        Gson gson = new Gson();
        try {
            URL url = new URL(   "https://api.sportmonks.com/v3/football/standings/live/leagues/" + leagueId + "?api_token=LYBrIj6r7azh3KhVgVjM8YAFeMRVBh68EkhD7cGfilOL2FJKwpLxIL62KvE3&include=participant&filter[team_id]=" + teamId 
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StandingTableApi response = gson.fromJson(in, StandingTableApi.class);
            return response;
        } catch (MalformedURLException ex) {
            Logger.getLogger(GsonExperiments.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GsonExperiments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

       }

    private static class GsonExperiments {

        public GsonExperiments() {
        }
    } 
    public static void main(String Args[]) {
    TeamInfoApi response = TeamInfoApi.getTeamInfo("barcelona");
    int homeTeamId = response.data[0].getTeamId();
    int leagueId = response.data[0].getSeasonsInfo().length;
    for(int i = 0; i < response.data.length; i++) {
        for(int j = 0; j < response.data[i].getSeasonsInfo().length; j++) {
            leagueId = response.data[i].getSeasonsInfo()[j].getLeagueId();
            try {
                StandingTableApi standingTableResp = StandingTableApi.getTable(leagueId, homeTeamId);
                for(int k = 0; k < standingTableResp.data.length; k++) {
                    int position = standingTableResp.data[k].getPosition();
                    int points = standingTableResp.data[k].getPoints();
                    String allTeamsInTheTable = standingTableResp.data[k].getTeamInfo().getTeamName();
                    System.out.println(position + " " + allTeamsInTheTable + " " + points);
                }
                break; // If we reach this point, we got a valid response, so we can exit the loop
            } catch (NullPointerException e) {
                // The response was null, so we caught an exception
                System.out.println("LeagueId " + leagueId + " didn't work.");
            }
        }
    }
}
}
    

