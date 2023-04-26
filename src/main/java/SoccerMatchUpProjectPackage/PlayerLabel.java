package SoccerMatchUpProjectPackage;


import ApiPackage.TopScorerApi;
import ApiPackage.TeamInfoApi;
import ApiPackage.StandingTableApi;
import static SoccerMatchUpProjectPackage.AllGames.getScaledIcon;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayerLabel {
    
    private int gameIndex;
    private JLabel[] gameLabel;

    public PlayerLabel(int gameIndex)
    {
        this.gameIndex = gameIndex;
        this.gameLabel = AllGames.getSingleGameInfo(gameIndex);
    }
       public JPanel getHomeTeamLabel(String teamName) {
       int gapSize = 10; // 10 pixels
       JPanel playersPanel = new JPanel();
       playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
       JLabel homeTeamName = new JLabel(teamName);
       homeTeamName.setFont(new Font(homeTeamName.getFont().getName(), Font.BOLD, homeTeamName.getFont().getSize() + 4));
       homeTeamName.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));
       playersPanel.add(homeTeamName);
       teamName = gameLabel[0].getText().replace(" ", "%20");
       TeamInfoApi response = TeamInfoApi.getTeamInfo(teamName);
       for (int i = 0; i < response.data.length; i++) {
           for (int j = 0; j < response.data[i].getPlayer().length; j++) {
               String playerName = response.data[i].getPlayer()[j].player().getPlayerName();
               String playerPosition = response.data[i].getPlayer()[j].player().getPositionId().getPosition();
               ImageIcon playerImage = getScaledIcon(response.data[i].getPlayer()[j].player().getPlayerImage());

               JLabel playerNameLabel = new JLabel(playerName);
               playerNameLabel.setFont(new Font(playerNameLabel.getFont().getName(), Font.BOLD, playerNameLabel.getFont().getSize()));
               playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JLabel playerImageLabel = new JLabel(playerImage);
               playerImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JLabel playerPositionLabel = new JLabel(playerPosition);
               playerPositionLabel.setFont(new Font(playerPositionLabel.getFont().getName(), Font.BOLD, playerPositionLabel.getFont().getSize()));
               playerPositionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JPanel playerPanel = new JPanel();
               playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
               playerPanel.add(playerNameLabel);
               playerPanel.add(playerImageLabel);
               playerPanel.add(playerPositionLabel);
               playerPanel.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));

               playersPanel.add(playerPanel);
           }
       }
       JScrollPane scroll = new JScrollPane(playersPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       return playersPanel;
   }


       public JPanel getAwayTeamLabel(String teamName) {
       int gapSize = 10; // 10 pixels
       JPanel playersPanel = new JPanel();
       playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
       teamName = gameLabel[4].getText().replace(" ", "%20");
       String awayTeam = teamName.replace("%20", " "); // replace %20 with space
       JLabel awayTeamName = new JLabel(awayTeam);
       awayTeamName.setFont(new Font(awayTeamName.getFont().getName(), Font.BOLD, awayTeamName.getFont().getSize() + 4));
       awayTeamName.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));
       playersPanel.add(awayTeamName);
       TeamInfoApi response = TeamInfoApi.getTeamInfo(teamName);
       for (int i = 0; i < response.data.length; i++) {
           for (int j = 0; j < response.data[i].getPlayer().length; j++) {
               String playerName = response.data[i].getPlayer()[j].player().getPlayerName();
               String playerPosition = response.data[i].getPlayer()[j].player().getPositionId().getPosition();
               ImageIcon playerImage = getScaledIcon(response.data[i].getPlayer()[j].player().getPlayerImage());

               JLabel playerNameLabel = new JLabel(playerName);
               playerNameLabel.setFont(new Font(playerNameLabel.getFont().getName(), Font.BOLD, playerNameLabel.getFont().getSize()));
               playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JLabel playerImageLabel = new JLabel(playerImage);
               playerImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JLabel playerPositionLabel = new JLabel(playerPosition);
               playerPositionLabel.setFont(new Font(playerPositionLabel.getFont().getName(), Font.BOLD, playerPositionLabel.getFont().getSize()));
               playerPositionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

               JPanel playerPanel = new JPanel();
               playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
               playerPanel.add(playerNameLabel);
               playerPanel.add(playerImageLabel);
               playerPanel.add(playerPositionLabel);
               playerPanel.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));

               playersPanel.add(playerPanel);
           }
       }
       JScrollPane scroll = new JScrollPane(playersPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       return playersPanel;
   }

    public List<JLabel[]> getTeamsStandings() {
        List<JLabel[]> standingTable = new ArrayList<>();
        
        String homeTeam = gameLabel[0].getText().replace(" ", "%20");
        TeamInfoApi response = TeamInfoApi.getTeamInfo(homeTeam);
        int homeTeamId = response.data[0].getTeamId();
        int leagueId = response.data[0].getSeasonsInfo()[0].getLeagueId();
        StandingTableApi standingTableResp = StandingTableApi.getTable(leagueId, homeTeamId);

        for (int i = 0; i < standingTableResp.data.length; i++) {
          int position = standingTableResp.data[i].getPosition();
          int points = standingTableResp.data[i].getPoints();
          String allTeamsInTheTable = standingTableResp.data[i].getTeamInfo().getTeamName();
          ImageIcon teamIcon = getScaledIcon(standingTableResp.data[i].getTeamInfo().getTeamIcon());
            JLabel[] standingInfo = new JLabel[] { 
                new JLabel("Position: " + position), 
                new JLabel("Points: " + points), 
                new JLabel("Team Name: "  +  allTeamsInTheTable),
                new JLabel(teamIcon)
            };
            standingTable.add(standingInfo);
        }
    return standingTable;
    }
    
    public List<JLabel[]> getTopScorersInSeason() {
        List<JLabel[]> allScorersLabel = new ArrayList<>();

        String homeTeam = gameLabel[0].getText().replace(" ", "%20");
        TeamInfoApi response = TeamInfoApi.getTeamInfo(homeTeam);
        int homeTeamId = response.data[0].getTeamId();
        int leagueId = response.data[0].getSeasonsInfo()[0].getLeagueId();
        StandingTableApi standingTableResp = StandingTableApi.getTable(leagueId, homeTeamId);
        TopScorerApi resp = TopScorerApi.getTopScorers(standingTableResp.data[0].getSeasonId());
        
        for (int i = 0; i < resp.data.length; i++) {
            String scorerName = resp.data[i].getScorerInfo().getScorerName();
            ImageIcon scorerImage = getScaledIcon(resp.data[i].getScorerInfo().getPlayerImage());
            int goals = resp.data[i].getScores();
            JLabel[] scorerLabel = new JLabel[] { 
                new JLabel(scorerName), 
                new JLabel(scorerImage), 
                new JLabel(" " + goals)
            };
            allScorersLabel.add(scorerLabel);
        }
        return allScorersLabel;
    }
}
    

