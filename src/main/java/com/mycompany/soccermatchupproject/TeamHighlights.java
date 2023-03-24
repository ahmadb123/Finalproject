
package com.mycompany.soccermatchupproject;
import gsonGetApi.getTeamInfoApi;
import gsonGetApi.standingTableApi;



public class TeamHighlights extends javax.swing.JFrame {
    private MainWindow mainWindow;
    private String teamName;
    private int width;
    private int height;
    public TeamHighlights(String teamName) {
        initComponents();
        this.teamName = teamName;
        getTeamInfoApi response = getTeamInfoApi.getTeamInfo(teamName);
        teamNameLabel.setText(response.data[0].getName());
        standingBtn.setText("Standings");
        coachName.setText("Coach");
        
        // constant image size 
        width = 55;
        height = 55;
        String iconUrl = response.data[0].getImage_path();
        teamIcon.setIcon(new javax.swing.JLabel() {
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
        squadBtn.setText("Squad");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamNameLabel = new javax.swing.JLabel();
        teamIcon = new javax.swing.JLabel();
        squadBtn = new javax.swing.JButton();
        player_one = new javax.swing.JLabel();
        player_image = new javax.swing.JLabel();
        standingBtn = new javax.swing.JButton();
        coachName = new javax.swing.JButton();
        position = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        teamNameLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        teamNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        teamIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        teamIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        teamIcon.setSize(new java.awt.Dimension(50, 50));

        squadBtn.setToolTipText("");
        squadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squadBtnActionPerformed(evt);
            }
        });

        standingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standingBtnActionPerformed(evt);
            }
        });

        coachName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachNameActionPerformed(evt);
            }
        });

        icon.setSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(teamIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(player_image, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teamNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(player_one, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(squadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(standingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coachName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(squadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(standingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(coachName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(player_one, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teamNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player_image, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(teamIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void squadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squadBtnActionPerformed
    getTeamInfoApi response = getTeamInfoApi.getTeamInfo(teamName);
    player_one.setText(response.data[0].getPlayer()[0].player().getPlayerName());
    String iconUrl = response.data[0].getPlayer()[0].player().getPlayerImage();
        player_image.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
        try {
            return new javax.swing.ImageIcon(
                new java.net.URL(iconUrl)
            );
        } catch (java.net.MalformedURLException e) {
        }
        return null;
        }
        }.getIcon()); 
    }//GEN-LAST:event_squadBtnActionPerformed

    private void coachNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachNameActionPerformed
    getTeamInfoApi response = getTeamInfoApi.getTeamInfo(teamName);
    coachName.setText(response.data[0].getCoachInfo()[0].coach().getCoachName());
    String iconUrl = response.data[0].getCoachInfo()[0].coach().getCoachImg();
        player_image.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
        try {
            return new javax.swing.ImageIcon(
                new java.net.URL(iconUrl)
            );
        } catch (java.net.MalformedURLException e) {
        }
        return null;
        }
        }.getIcon());     }//GEN-LAST:event_coachNameActionPerformed

    private void standingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standingBtnActionPerformed
        getTeamInfoApi response = getTeamInfoApi.getTeamInfo(teamName);
        int teamId = response.data[0].getTeamId();
        int leagueId = response.data[0].getSeasonsInfo()[0].getLeagueId();
        standingTableApi responseTwo = standingTableApi.getTable(leagueId, teamId);
//        position.setText(String.valueOf(responseTwo.data[0].getPosition()));
//        points.setText(String.valueOf(responseTwo.data[0].getPoints()));
//        name.setText(responseTwo.data[0].getTeamInfo().getTeamName());
        for (int i = 0; i < responseTwo.data.length; i ++)
        {
                int position = responseTwo.data[i].getPosition();
                int points = responseTwo.data[i].getPoints();
                String teamName = responseTwo.data[i].getTeamInfo().getTeamName();
                System.out.println("Position: " + position + ", Points: " + points + ", Team Name: " + teamName);
        }
        String iconUrl = responseTwo.data[0].getTeamInfo().getTeamIcon();
        int width = 55; // Set the desired width of the image
        int height = 55; // Set the desired height of the image
        
        icon.setIcon(new javax.swing.JLabel() {
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

    }//GEN-LAST:event_standingBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coachName;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel name;
    private javax.swing.JLabel player_image;
    private javax.swing.JLabel player_one;
    private javax.swing.JLabel points;
    private javax.swing.JLabel position;
    private javax.swing.JButton squadBtn;
    private javax.swing.JButton standingBtn;
    private javax.swing.JLabel teamIcon;
    private javax.swing.JLabel teamNameLabel;
    // End of variables declaration//GEN-END:variables
}
