package com.mycompany.soccermatchupproject;
import static com.mycompany.soccermatchupproject.AllGames.LiveFixtureInfo;
import gsonGetApi.GetLatestFixtures;
import gsonGetApi.LiveFixtureInfo;
import gsonGetApi.ScoresInGame;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame{
    private TeamHighlights win;
    
    public MainWindow() {
        initComponents();
//       win = new TeamHighlights(teamName);
        
        appNameLabel.setText("365 Scores Demo");
        favoriteTeamBtn.setText("Search Team");
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1); 
        GetLatestFixtures resp = GetLatestFixtures.getLatestFixtureByDate( fromDate, currentDate);

  
        
        List<JLabel> allTeamsIcons = new ArrayList<>();
        allTeamsIcons.add(teamOneIcon);
        allTeamsIcons.add(teamTwoIcon);
        allTeamsIcons.add(teamOneIconSecondGame);
        allTeamsIcons.add(teamTwoIconSecondGame);
        allTeamsIcons.add(teamOneIconGameThree);
        allTeamsIcons.add(teamTwoIconGameThree);
        
        List<JLabel> allTeamsGoals = new ArrayList<>();
        allTeamsGoals.add(homeGoals);
        allTeamsGoals.add(awayGoals);
        allTeamsGoals.add(gameTwoHomeGoals);
        allTeamsGoals.add(teamTwoAwayGoals);
        allTeamsGoals.add(homeGoalsTeamOneGameThree);
        allTeamsGoals.add(awayGoalsTeamTwoGameThree);
        
        
        for (int i = 0; i < allTeamsIcons.size(); i++) { 
            int gameIndex = i / 2; // calculate the game index based on the label index
            int teamIndex = i % 2; // calculate the team index based on the label index
            String iconUrl = resp.data[gameIndex].getParticipantsNames()[teamIndex].getTeamLogo();
            allTeamsIcons.get(i).setIcon(getScaledIcon(iconUrl));
        }   
        for (int i = 0; i < resp.data.length; i++)
        {
            ScoresInGame[] scores = resp.data[i].getScoresInfo();
            for (int j = 0; j < allTeamsGoals.size() / 2; j++) {
                int finalResults[] = LiveFixtureInfo.finalScores(scores);
                int homeGoals = finalResults[0];
                int awayGoals = finalResults[1];
                allTeamsGoals.get(j).setText(String.valueOf(homeGoals));
                allTeamsGoals.get(j + 1).setText(String.valueOf(awayGoals));
            }
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appNameLabel = new javax.swing.JLabel();
        favoriteTeamBtn = new javax.swing.JButton();
        txtLabel = new javax.swing.JLabel();
        teamName = new javax.swing.JLabel();
        teamOneIcon = new javax.swing.JLabel();
        homeGoals = new javax.swing.JLabel();
        teamTwoIcon = new javax.swing.JLabel();
        teamTwoName = new javax.swing.JLabel();
        awayGoals = new javax.swing.JLabel();
        showGameDetails = new javax.swing.JButton();
        teamOneSecondGame = new javax.swing.JLabel();
        teamTwoSecondGame = new javax.swing.JLabel();
        teamOneIconSecondGame = new javax.swing.JLabel();
        teamTwoIconSecondGame = new javax.swing.JLabel();
        gameTwoHomeGoals = new javax.swing.JLabel();
        teamTwoAwayGoals = new javax.swing.JLabel();
        showGameTwoGameDetails = new javax.swing.JButton();
        teamNameGameThree = new javax.swing.JLabel();
        teamOneIconGameThree = new javax.swing.JLabel();
        homeGoalsTeamOneGameThree = new javax.swing.JLabel();
        awayGoalsTeamTwoGameThree = new javax.swing.JLabel();
        teamTwoNameGameThree = new javax.swing.JLabel();
        teamTwoIconGameThree = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        appNameLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        appNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        favoriteTeamBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        favoriteTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteTeamBtnActionPerformed(evt);
            }
        });

        txtLabel.setText("Popular Fixtures:");

        awayGoals.setToolTipText("");

        showGameDetails.setText("Full Details");
        showGameDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGameDetailsActionPerformed(evt);
            }
        });

        showGameTwoGameDetails.setText("Full Details");
        showGameTwoGameDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGameTwoGameDetailsActionPerformed(evt);
            }
        });

        teamNameGameThree.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(favoriteTeamBtn))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teamName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teamOneIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(awayGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teamTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(teamTwoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(showGameDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(teamOneSecondGame, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamOneIconSecondGame, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gameTwoHomeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamTwoAwayGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(teamNameGameThree, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(teamOneIconGameThree, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(homeGoalsTeamOneGameThree, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(awayGoalsTeamTwoGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(174, 174, 174)
                                    .addComponent(showGameTwoGameDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teamTwoSecondGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teamTwoNameGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teamTwoIconSecondGame, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(teamTwoIconGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favoriteTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teamName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teamOneIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(awayGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(teamTwoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(teamTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(showGameDetails)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teamOneSecondGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teamOneIconSecondGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(teamTwoAwayGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gameTwoHomeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(teamTwoSecondGame, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(teamTwoIconSecondGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showGameTwoGameDetails)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeGoalsTeamOneGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teamOneIconGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teamNameGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(awayGoalsTeamTwoGameThree, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teamTwoNameGameThree, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamTwoIconGameThree, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void favoriteTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteTeamBtnActionPerformed
        String teamName = JOptionPane.showInputDialog(null, "Search Team", "Team Search", JOptionPane.PLAIN_MESSAGE);
        TeamHighlights teamHighlightsWin = new TeamHighlights(teamName);
        teamHighlightsWin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_favoriteTeamBtnActionPerformed

    private void showGameDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGameDetailsActionPerformed
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
        GetLatestFixtures resp = GetLatestFixtures.getLatestFixtureByDate(fromDate, currentDate);
        ScoresInGame[] scoresInfo = resp.data[0].getScoresInfo();
        String formattedScores = LiveFixtureInfo(scoresInfo);
        JOptionPane.showOptionDialog(null, formattedScores, "Game Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

    }//GEN-LAST:event_showGameDetailsActionPerformed

    private void showGameTwoGameDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGameTwoGameDetailsActionPerformed
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
        GetLatestFixtures resp = GetLatestFixtures.getLatestFixtureByDate(fromDate, currentDate);
        ScoresInGame[] scoresInfo = resp.data[1].getScoresInfo();
        String formattedScores = LiveFixtureInfo(scoresInfo);
        JOptionPane.showOptionDialog(null, formattedScores, "Game Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    }//GEN-LAST:event_showGameTwoGameDetailsActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JLabel awayGoals;
    private javax.swing.JLabel awayGoalsTeamTwoGameThree;
    private javax.swing.JButton favoriteTeamBtn;
    private javax.swing.JLabel gameTwoHomeGoals;
    private javax.swing.JLabel homeGoals;
    private javax.swing.JLabel homeGoalsTeamOneGameThree;
    private javax.swing.JButton showGameDetails;
    private javax.swing.JButton showGameTwoGameDetails;
    private javax.swing.JLabel teamName;
    private javax.swing.JLabel teamNameGameThree;
    private javax.swing.JLabel teamOneIcon;
    private javax.swing.JLabel teamOneIconGameThree;
    private javax.swing.JLabel teamOneIconSecondGame;
    private javax.swing.JLabel teamOneSecondGame;
    private javax.swing.JLabel teamTwoAwayGoals;
    private javax.swing.JLabel teamTwoIcon;
    private javax.swing.JLabel teamTwoIconGameThree;
    private javax.swing.JLabel teamTwoIconSecondGame;
    private javax.swing.JLabel teamTwoName;
    private javax.swing.JLabel teamTwoNameGameThree;
    private javax.swing.JLabel teamTwoSecondGame;
    private javax.swing.JLabel txtLabel;
    // End of variables declaration//GEN-END:variables
}
