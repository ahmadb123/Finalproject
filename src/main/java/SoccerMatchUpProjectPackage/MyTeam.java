package SoccerMatchUpProjectPackage;

import static SoccerMatchUpProjectPackage.AllGames.getScaledIcon;

import ApiPackage.MyTeamScores;
import ApiPackage.TeamInfoApi;
import ApiPackage.StandingTableApi;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyTeam {

  public static List<JLabel[]> getMyTeamLabel(String teamName) {
    TeamInfoApi response = TeamInfoApi.getTeamInfo(teamName);
    List<JLabel[]> gameLabels = new ArrayList<>();
    for (int i = 0; i < response.data.length; i++) {
      for (int j = 0; j < response.data[i].getLatestInfo().length; j++) {
        String homeTeamName =
          response.data[i].getLatestInfo()[j].getParticipants()[0].teamName();
        String awayTeamName =
          response.data[i].getLatestInfo()[j].getParticipants()[1].teamName();
        ImageIcon homeTeamIcon = getScaledIcon(
          response.data[i].getLatestInfo()[j].getParticipants()[0].getTeamIcon()
        );
        ImageIcon awayTeamIcon = getScaledIcon(
          response.data[i].getLatestInfo()[j].getParticipants()[1].getTeamIcon()
        );

        MyTeamScores[] scores =
          response.data[i].getLatestInfo()[j].getTeamScores();
        int finalResults[] = MyTeamScores.finalScores(scores);

        JLabel[] gameLabel = new JLabel[] {
          new JLabel(homeTeamIcon),
          new JLabel(homeTeamName),
          new JLabel(finalResults[0] + " - " + finalResults[1]),
          new JLabel(awayTeamIcon),
          new JLabel(awayTeamName),
        };
        gameLabels.add(gameLabel);
      }
    }
    return gameLabels;
  }

  public static List<JLabel[]> getSquad(String teamName) {
    TeamInfoApi response = TeamInfoApi.getTeamInfo(teamName);
    List<JLabel[]> squadLabel = new ArrayList<>();
    String managerName =
      response.data[0].getCoachInfo()[0].coach().getCoachName();
    ImageIcon managerImage = getScaledIcon(
      response.data[0].getCoachInfo()[0].coach().getCoachImg()
    );
    Font font = new Font("Arial", Font.PLAIN, 16);
    JLabel managerNameLabel = new JLabel("Manager Name: " + managerName);
    managerNameLabel.setFont(font);
    JLabel managerImageLabel = new JLabel(managerImage);
    JLabel managerPosition = new JLabel("Position: Coach");
    managerPosition.setFont(font);
    managerPosition.setBackground(Color.blue);

    // Add coach's name and image to squadLabel
    JLabel[] coachLabel = new JLabel[] {
      managerNameLabel,
      managerPosition,
      managerImageLabel,
    };
    squadLabel.add(coachLabel);

    for (int i = 0; i < response.data.length; i++) {
      for (int j = 0; j < response.data[i].getPlayer().length; j++) {
        String playerName =
          response.data[i].getPlayer()[j].player().getPlayerName();
        String playerPosition =
          response
            .data[i].getPlayer()[j].player()
            .getPositionId()
            .getPosition();
        ImageIcon playerImage = getScaledIcon(
          response.data[i].getPlayer()[j].player().getPlayerImage()
        );
        JLabel playerNameLable = new JLabel("Player Name :" + " " + playerName);
        JLabel playerPositionLabel = new JLabel(
          "Player Position :" + " " + playerPosition
        );
        playerNameLable.setFont(font);
        playerPositionLabel.setFont(font);
        JLabel[] playerLabel = new JLabel[] {
          playerNameLable,
          playerPositionLabel,
          new JLabel(playerImage),
        };
        squadLabel.add(playerLabel);
      }
    }
    return squadLabel;
  }
  
    public static List<JLabel[]> getTeamsStandings(String teamName) {
        List<JLabel[]> standingTable = new ArrayList<>();
        TeamInfoApi response = TeamInfoApi.getTeamInfo(teamName);
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
}
