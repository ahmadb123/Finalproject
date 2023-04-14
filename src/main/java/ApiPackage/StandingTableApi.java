
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
            URL url = new URL(   "https://api.sportmonks.com/v3/football/standings/live/leagues/" + leagueId + "?api_token=MiZTldKex63o2mbR2Rf1iwRIn5ZK17ErFR1ianlfJaoCeBltZuLY27B8rYXF&include=participant&filter[team_id]=" + teamId 
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
}
