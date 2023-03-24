
package com.mycompany.soccermatchupproject;
import gsonGetApi.GetLatestFixtures;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame{
    private TeamHighlights teamHighlightsWin;
    
    public MainWindow() {
        initComponents();
        appNameLabel.setText("365 Scores Demo");
        favoriteTeamBtn.setText("Search Team");
//        gameHighlightsWin = new GameHighlights();
//        gameHighlightsWin.mainWindow(this); 
    LocalDate currentDate = LocalDate.now();
    LocalDate fromDate = currentDate.minusDays(1);
    GetLatestFixtures resp = GetLatestFixtures.getLatestFixtureByDate( fromDate, currentDate);
    teamName.setText(resp.data[0].getParticipantsNames()[0].getTeamName());
    teamTwoName.setText(resp.data[0].getParticipantsNames()[1].getTeamName());
//    teamName.setText(resp.data[0].getParticipantsNames()[0].getTeamName());
        int width = 45;
        int height = 45;
        String iconUrl = resp.data[0].getParticipantsNames()[0].getTeamLogo();
        teamOneIcon.setIcon(new javax.swing.JLabel() {
        public javax.swing.Icon getIcon() {
        try {
            java.net.URL url = new java.net.URL(iconUrl);
            java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(url);
            java.awt.Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new javax.swing.ImageIcon(scaledImage);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    }.getIcon());
        
        String iconUrlTwo = resp.data[0].getParticipantsNames()[1].getTeamLogo();
        teamTwoIcon.setIcon(new javax.swing.JLabel() {
        public javax.swing.Icon getIcon() {
        try {
            java.net.URL url = new java.net.URL(iconUrlTwo);
            java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(url);
            java.awt.Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new javax.swing.ImageIcon(scaledImage);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    }.getIcon());

    
    homeGoals.setText(String.valueOf(resp.data[0].getScoresInfo()[resp.data[0].getScoresInfo().length - 1].getScore().getGoals()));
    awayGoals.setText(String.valueOf(resp.data[0].getScoresInfo()[resp.data[0].getScoresInfo().length - 2].getScore().getGoals()));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(favoriteTeamBtn))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teamName, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teamOneIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(homeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(awayGoals)
                        .addGap(84, 84, 84)
                        .addComponent(teamTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teamTwoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(showGameDetails)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(favoriteTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(teamName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(teamOneIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(teamTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(awayGoals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(homeGoals, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(159, Short.MAX_VALUE)
                        .addComponent(teamTwoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showGameDetails)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void favoriteTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteTeamBtnActionPerformed
        String teamName = JOptionPane.showInputDialog(null, "Search Team", "Team Search", JOptionPane.PLAIN_MESSAGE);
        TeamHighlights teamHighlightsWin = new TeamHighlights(teamName);
        teamHighlightsWin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_favoriteTeamBtnActionPerformed

    private void showGameDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGameDetailsActionPerformed
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.minusDays(1);
        GetLatestFixtures resp = GetLatestFixtures.getLatestFixtureByDate( fromDate, currentDate);
       

    }//GEN-LAST:event_showGameDetailsActionPerformed


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
    private javax.swing.JButton favoriteTeamBtn;
    private javax.swing.JLabel homeGoals;
    private javax.swing.JButton showGameDetails;
    private javax.swing.JLabel teamName;
    private javax.swing.JLabel teamOneIcon;
    private javax.swing.JLabel teamTwoIcon;
    private javax.swing.JLabel teamTwoName;
    private javax.swing.JLabel txtLabel;
    // End of variables declaration//GEN-END:variables
}
