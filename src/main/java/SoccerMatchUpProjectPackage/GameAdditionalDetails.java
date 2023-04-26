
package SoccerMatchUpProjectPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class GameAdditionalDetails extends javax.swing.JFrame {
    
    private MainWindow window;
    private int gameIndex;
    JLabel[] gameLabel;
    final Font teamNameFont = new Font("Times New Roman", Font.BOLD, 14);

    
    public GameAdditionalDetails(JLabel[] results, int gameIndex) {
        this.gameIndex = gameIndex; 
        this.gameLabel = AllGames.getSingleGameInfo(gameIndex);
        initComponents();
        initGameDetails();
    }
   private void initGameDetails() {
    setTitle("Additional Details");
    JPanel windowPanel = new JPanel(new BorderLayout()); // Use BorderLayout here
    
    JPanel gamePanel = new JPanel(new GridLayout(0,2,10,10));
    gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        
    JPanel matchPanel = new JPanel();
    matchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    matchPanel.setBackground(Color.lightGray);
    
    matchPanel.setPreferredSize(new Dimension(100, 80));
    windowPanel.setPreferredSize(new Dimension(500,225));
    for(int i = 0; i < gameLabel.length - 1; i++) {
        gameLabel[i].setFont(teamNameFont);
        matchPanel.add(gameLabel[i]);
    }
    windowPanel.add(matchPanel, BorderLayout.PAGE_START); // Add the match panel to the north of the window panel
    
    JButton teamOnePlayers = new javax.swing.JButton();
    JButton teamTwoPlayers = new javax.swing.JButton();
    JButton standingTable = new javax.swing.JButton();
    JButton backButton = new javax.swing.JButton();
    JButton getTopScorer = new javax.swing.JButton();
    JButton showFullDetails = new javax.swing.JButton();
    JButton gameEvent = new javax.swing.JButton();

    teamOnePlayers.setText("Squad 1");
    teamOnePlayers.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            TeamOnePlayersActionPerformed(evt);
        }
    });

    teamTwoPlayers.setText("Squad 2");
    teamTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            teamTwoPlayersActionPerformed(evt);
        }
    });

    standingTable.setText("Standing Table");
    standingTable.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            standingTableActionPerformed(evt);
        }
    });

    backButton.setText("Back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backButtonActionPerformed(evt);
        }
    });

    getTopScorer.setText("Top Scorers");
    getTopScorer.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            getTopScorerActionPerformed(evt);
        }
    });

    showFullDetails.setText("Game Details");
    showFullDetails.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            showFullDetailsActionPerformed(evt);
        }
    });
    
    gameEvent.setText("Events");
    gameEvent.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            gameEvents(evt);
        }
    });
    JPanel buttonsPanel = new JPanel(new GridLayout(2,3,10,10)); // Use a GridLayout with 2 rows and 3 columns
    buttonsPanel.add(teamOnePlayers);
    buttonsPanel.add(teamTwoPlayers);
    buttonsPanel.add(standingTable);
    buttonsPanel.add(getTopScorer);
    buttonsPanel.add(showFullDetails);
    buttonsPanel.add(gameEvent);
    buttonsPanel.add(backButton);
    windowPanel.add(buttonsPanel, BorderLayout.CENTER); // Add the buttons panel to the center of the window panel
    JScrollPane scrollPane = new JScrollPane(windowPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    windowPanel.setBackground(Color.DARK_GRAY);
    setLayout(new BorderLayout());
    add(scrollPane, BorderLayout.CENTER);
    pack();
    setVisible(true);
    pack();
}

    
    public void HomePage(MainWindow homePage){
        window = homePage;
    }

    private void TeamOnePlayersActionPerformed(java.awt.event.ActionEvent evt) {                                               
        PlayerLabel playerLabel = new PlayerLabel(gameIndex);

      // call the getAwayTeamLabel function on the playerLabel instance
        JPanel teamPlayersPanel = playerLabel.getHomeTeamLabel(gameLabel[0].getText());

        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));

        for (Component comp : teamPlayersPanel.getComponents()) {
            playersPanel.add(comp);
        }

        // create a new JScrollPane instance and add the playersPanel to it
        JScrollPane playersScrollPane = new JScrollPane(playersPanel);

        // create a new JFrame instance and set its content pane to the JScrollPane
        JFrame playersFrame = new JFrame();
        playersFrame.setContentPane(playersScrollPane);
        playersFrame.pack();
        playersFrame.setSize(300,400);
        playersFrame.setVisible(true);
    }

    private void teamTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {                                               
        PlayerLabel playerLabel = new PlayerLabel(gameIndex);
        
        // call the getAwayTeamLabel function on the playerLabel instance
        JPanel teamPlayersPanel = playerLabel.getAwayTeamLabel(gameLabel[4].getText());

        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));

        for (Component comp : teamPlayersPanel.getComponents()) {
            playersPanel.add(comp);
        }

        // create a new JScrollPane instance and add the playersPanel to it
        JScrollPane playersScrollPane = new JScrollPane(playersPanel);

        // create a new JFrame instance and set its content pane to the JScrollPane
        JFrame playersFrame = new JFrame();
        playersFrame.setContentPane(playersScrollPane);
        playersFrame.pack();
        playersFrame.setSize(300,400);
        playersFrame.setVisible(true);  
        playersFrame.setLocationRelativeTo(null);
    }

    private void gameEvents(java.awt.event.ActionEvent evt) {
        List<JLabel[]> events = AllGames.getGameEvent(gameIndex);

        if (events == null || events.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No events for this game.");
        } else {
        JPanel panel = new JPanel();
        JPanel goalsPanel = new JPanel();
        goalsPanel.setLayout(new BoxLayout(goalsPanel, BoxLayout.PAGE_AXIS));
        JPanel yellowCardsPanel = new JPanel();
        yellowCardsPanel.setLayout(new BoxLayout(yellowCardsPanel, BoxLayout.PAGE_AXIS));

        for (JLabel[] event : events) {
            if (event[0].getText().startsWith("GOAL")) {
                goalsPanel.add(event[0]);
                goalsPanel.add(event[1]);
                goalsPanel.add(event[2]);
                panel.add(goalsPanel);
            } else if (event[0].getText().startsWith("YELLOW CARD")) {
                yellowCardsPanel.add(event[0]);
                yellowCardsPanel.add(event[1]);
                yellowCardsPanel.add(event[2]);
                panel.add(yellowCardsPanel);
            }
        }
       JScrollPane scrollPane = new JScrollPane(panel);

        JFrame frame = new JFrame(" Game Events");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(panel.getPreferredSize().width,panel.getPreferredSize().height);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

   }


    private void standingTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standingTableActionPerformed
        PlayerLabel teamStanding = new PlayerLabel(gameIndex);
        List<JLabel[]> matchStanding = teamStanding.getTeamsStandings();
        JPanel panel = new JPanel(new GridLayout(matchStanding.size(), 2));
        for (JLabel[] matchTable : matchStanding) {
            panel.add(matchTable[0]);
            panel.add(matchTable[1]);
            panel.add(matchTable[2]);
            panel.add(matchTable[3]);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        JFrame frame = new JFrame("Standing Table");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_standingTableActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_backButtonActionPerformed

    private void getTopScorerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTopScorerActionPerformed
        PlayerLabel topScorers = new PlayerLabel(gameIndex);
        List<JLabel[]> scoreLabel = topScorers.getTopScorersInSeason();
        JPanel panel = new JPanel(new GridLayout(scoreLabel.size(), 3));
        for (JLabel[] matchTable : scoreLabel) {
            panel.add(matchTable[0]);
            panel.add(matchTable[1]);
            panel.add(matchTable[2]);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        JFrame frame = new JFrame("Top Scorers");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_getTopScorerActionPerformed

  private void showFullDetailsActionPerformed(java.awt.event.ActionEvent evt) {
    if (gameLabel[5].getText() == null) {
      JOptionPane.showMessageDialog(null, "No Events for this game");
    } else {
      JOptionPane.showMessageDialog(null, gameLabel[5].getText());
    }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
