
package gsonGetApi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RecentTransfersApi {
    public recentTransfersInfo[] data;
    public static RecentTransfersApi recentTransfers()
    {
         Gson gson = new Gson();
        try {
            URL url = new URL("https://api.sportmonks.com/v3/football/transfers/latest?api_token=MiZTldKex63o2mbR2Rf1iwRIn5ZK17ErFR1ianlfJaoCeBltZuLY27B8rYXF&include=player;fromTeam;toTeam"
            );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            RecentTransfersApi response = gson.fromJson(in, RecentTransfersApi.class);
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
