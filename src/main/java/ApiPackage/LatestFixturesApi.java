
package ApiPackage;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LatestFixturesApi {
    public LiveFixtureInfo[] data;

    public static LatestFixturesApi getLatestFixtureByDate(LocalDate fromDate, LocalDate toDate) {
        Gson gson = new Gson();
        try {
            URL url = new URL("https://api.sportmonks.com/v3/football/fixtures/between/" + fromDate + "/" + toDate + "?api_token=LYBrIj6r7azh3KhVgVjM8YAFeMRVBh68EkhD7cGfilOL2FJKwpLxIL62KvE3&include=scores;participants;events.player&filters=eventTypes:14,19"
        );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            LatestFixturesApi response = gson.fromJson(in, LatestFixturesApi.class);
            return response;
        } catch (MalformedURLException ex) {
            Logger.getLogger(GsonExperiments.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GsonExperiments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       private static class GsonExperiments {
    }
       public static void main(String args[])
       {
            LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
           LatestFixturesApi rep = LatestFixturesApi.getLatestFixtureByDate(currentDate, fromDate);
           System.out.print(rep.data[0].getGameTime());
       }
}

