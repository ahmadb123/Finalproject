package SoccerMatchUpProjectPackage;

import ApiPackage.LatestFixturesApi;
import ApiPackage.LiveFixtureInfo;
import ApiPackage.ScoresInGame;
import ApiPackage.UpcomingFixturesApi;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AllGames {
    
    public static List<JLabel[]> getGameLabels() {
        List<JLabel[]> gameLabels = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
        LatestFixturesApi resp = LatestFixturesApi.getLatestFixtureByDate(fromDate, currentDate);
        for (LiveFixtureInfo fixture : resp.data) {
            String homeTeamName = fixture.getParticipantsNames()[0].getTeamName();
            String awayTeamName = fixture.getParticipantsNames()[1].getTeamName();  
            ImageIcon homeTeamIcon = getScaledIcon(fixture.getParticipantsNames()[0].getTeamLogo());
            ImageIcon awayTeamIcon = getScaledIcon(fixture.getParticipantsNames()[1].getTeamLogo());
            ScoresInGame[] scores = fixture.getScoresInfo();
            int finalResults[] = LiveFixtureInfo.finalScores(scores);
            JLabel[] gameLabel = new JLabel[] { 
                new JLabel(homeTeamName + " " + "(Home)"), 
                new JLabel(homeTeamIcon), 
                new JLabel(finalResults[0] + " - " + finalResults[1]), 
                new JLabel(awayTeamIcon), 
                new JLabel(awayTeamName + " " + "(Away)"),
                new JLabel(LiveFixtureInfo(scores))
            };
            gameLabels.add(gameLabel);
        }
        return gameLabels;
    }

    public static ImageIcon getScaledIcon(String url) {
        int width = 45;
        int height = 45;
        try {
            java.net.URL imageUrl = new java.net.URL(url);
            java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(imageUrl);
            java.awt.Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new javax.swing.ImageIcon(scaledImage);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String LiveFixtureInfo(ScoresInGame[] scoresInfo) {
        if(scoresInfo == null || scoresInfo.length == 0) {
            return null; // no goals or games
        }
        
        StringBuilder message = new StringBuilder();
        int homeGoalsFirstHalf = 0;
        int awayGoalsFirstHalf = 0;
        int homeGoalsSecondHalf = 0;
        int awayGoalsSecondHalf = 0;
    
        // Count home and away goals
        for (int i = 0; i < scoresInfo.length; i++) {
            if (scoresInfo[i].getScore().getParticipant().equals("home")
                    && scoresInfo[i].getGameDesc().equals("1ST_HALF")) {
                homeGoalsFirstHalf += scoresInfo[i].getScore().getGoals();
            } else if (scoresInfo[i].getScore().getParticipant().equals("away")
                    && scoresInfo[i].getGameDesc().equals("1ST_HALF")) {
                awayGoalsFirstHalf += scoresInfo[i].getScore().getGoals();
            } else if (scoresInfo[i].getScore().getParticipant().equals("home")
                    && scoresInfo[i].getGameDesc().equals("2ND_HALF")) {
                homeGoalsSecondHalf += scoresInfo[i].getScore().getGoals();
            } else if (scoresInfo[i].getScore().getParticipant().equals("away")
                    && scoresInfo[i].getGameDesc().equals("2ND_HALF")) {
                awayGoalsSecondHalf += scoresInfo[i].getScore().getGoals();
            }
        }
        // Print home and away goals for first half
        message.append("First Half: ").append(homeGoalsFirstHalf).append(" - ").append(awayGoalsFirstHalf).append("\n");
        // Print home and away goals for second half
        message.append("Second Half: ").append(homeGoalsSecondHalf).append(" - ").append(awayGoalsSecondHalf).append("\n");
        return message.toString();
    }
     
    public static JLabel[] getSingleGameInfo(int index) {
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
        LatestFixturesApi resp = LatestFixturesApi.getLatestFixtureByDate(fromDate, currentDate);
        LiveFixtureInfo fixture = resp.data[index];
        String homeTeamName = fixture.getParticipantsNames()[0].getTeamName();
        String awayTeamName = fixture.getParticipantsNames()[1].getTeamName();  
        ImageIcon homeTeamIcon = getScaledIcon(fixture.getParticipantsNames()[0].getTeamLogo());
        ImageIcon awayTeamIcon = getScaledIcon(fixture.getParticipantsNames()[1].getTeamLogo());
        ScoresInGame[] scores = fixture.getScoresInfo();
        int finalResults[] = LiveFixtureInfo.finalScores(scores);
        JLabel[] gameLabel = new JLabel[] { 
            new JLabel(homeTeamName), 
            new JLabel(homeTeamIcon), 
            new JLabel(finalResults[0] + " - " + finalResults[1]), 
            new JLabel(awayTeamIcon), 
            new JLabel(awayTeamName),
            new JLabel(LiveFixtureInfo(scores))
        };
        return gameLabel;
    }
    
    public static List<JLabel[]> getUpcomingFixtures() {
        LocalDate todayDate = LocalDate.now();
        UpcomingFixturesApi resp = UpcomingFixturesApi.getUpcomingFixtures(todayDate);
        if (resp == null || resp.data == null || resp.data.length == 0) {
            resp.ifThereNoGames();
            return null;
        }
        List<JLabel[]> upcomingMatches = new ArrayList<>();
        for (int i = 0; i < resp.data.length; i++) {
            String match = resp.data[i].getGameName();
            String matchTime = resp.data[i].getGameTime();
            JLabel[] matchLabel = new JLabel[] { 
                new JLabel("Game " + (i + 1)+ " " +  match), 
                new JLabel("On/At: " + matchTime), 
            };
            upcomingMatches.add(matchLabel);
        }
        return upcomingMatches;
    }
}
