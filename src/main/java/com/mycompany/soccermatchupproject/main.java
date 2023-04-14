package com.mycompany.soccermatchupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class main extends javax.swing.JFrame {
    private TeamHighlights teamHighlightWin;
    private GameAdditionalDetails gameAdditionalDetailsWin;
    private List<JButton> buttons;    
    final Font teamNameFont = new Font("Times New Roman", Font.BOLD, 14);
    final Font scoreFont = new Font("Chalkboard SE", Font.CENTER_BASELINE, 14);
    final Font jlabelFont = new Font("Times New Roman", Font.BOLD, 20);
    public main() {
        initComponents();
        initGameLabels();
    }


    private void initGameLabels() {

        setTitle("Main Window"); // call setTitle method 
        buttons = new ArrayList<>();

        
        JPanel panel = new JPanel();
        
        JButton upcomingFixtures = new javax.swing.JButton(); // create JButton
        upcomingFixtures.setText("Who's playing today?");
        upcomingFixtures.setBounds(580, 0, 150, 70);
        upcomingFixtures.addActionListener(new ActionListener() { // call addActionListner method
            public void actionPerformed(ActionEvent evt) {
            upcomingLiveFixture(evt);
            }
        });
        
        JButton searchTeam = new javax.swing.JButton();
        searchTeam.setText("Search Team");
        searchTeam.setBounds(730 , 0 , 150 , 70);
        searchTeam.addActionListener(new java.awt.event.ActionListener()
                {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        searchTeam(evt);
                    }
                });
        JButton news = new javax.swing.JButton();
        news.setText("Recent Transfers");
        news.setBounds(650, 68, 150, 70);
        news.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                news(evt);
            }
        });
        
        JPanel gameLabelsPanel = new JPanel(new GridLayout(0,2,10,10)); // Set the layout of the panel
        gameLabelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Set an empty border 
        
        JLabel textLabel = new JLabel("Popular Recent Football fixtures: ");
        textLabel.setFont(jlabelFont);
        gameLabelsPanel.add(textLabel);
                  // Get the game labels for each fixture
        List<JLabel[]> gameLabelsList = AllGames.getGameLabels();

        // Create a new panel for each game and add it to the gameLabelsPanel
        for (int i = 0; i < gameLabelsList.size(); i++) {
            JLabel[] gameLabels = gameLabelsList.get(i);
            JButton showGameDetails = new javax.swing.JButton();
            showGameDetails.setText("Full Details");

            // add an ActionListener to each button
            showGameDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    showGameDetails(evt);
                }
            });
            buttons.add(showGameDetails);
            JPanel gamePanel = new JPanel(); // Set the layout of the panel
            gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); // Set a border
            gamePanel.setBackground(Color.WHITE); // Set a background color

            // Add the game labels to the game panel
            gameLabels[0].setFont(teamNameFont);
            gamePanel.add(gameLabels[0]);
            gamePanel.add(gameLabels[1]);
            gameLabels[2].setFont(scoreFont);
            gamePanel.add(gameLabels[2]);
            gamePanel.add(gameLabels[3]);
            gameLabels[4].setFont(teamNameFont);
            gamePanel.add(gameLabels[4]);
    
            gamePanel.add(showGameDetails);
            // Add the game panel to the gameLabelsPanel
            gameLabelsPanel.add(gamePanel);
        }
        
        gameLabelsPanel.add(upcomingFixtures); // update the button to the panel
        gameLabelsPanel.add(searchTeam); // update the button to the panel
        gameLabelsPanel.add(news);
        gameLabelsPanel.setBackground(Color.GRAY);
        panel.add(gameLabelsPanel);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showGameDetails(java.awt.event.ActionEvent evt) {
        int buttonIndex = buttons.indexOf(evt.getSource());
        if (buttonIndex >= 0) {
            JLabel[] gameLabels = AllGames.getGameLabels().get(buttonIndex);
            gameAdditionalDetailsWin = new GameAdditionalDetails( gameLabels, buttonIndex);
            gameAdditionalDetailsWin.setVisible(true);
            this.setVisible(false);
            gameAdditionalDetailsWin.setLocationRelativeTo(null); 
            gameAdditionalDetailsWin.HomePage(this);
        }
    }
    private void upcomingLiveFixture(ActionEvent evt) {
        List<JLabel[]> matchLabels = AllGames.getUpcomingFixtures();
        if (matchLabels == null) {
            // no upcoming games

            return;
        }

        // Create a new JFrame to show the matches
        JFrame frame = new JFrame("Upcoming Matches");
        JPanel panel = new JPanel(new GridLayout(matchLabels.size(), 2));

        // Loop through the matches and add them to the panel
        for (JLabel[] matchLabel : matchLabels) {
            panel.add(matchLabel[0]);
            panel.add(matchLabel[1]);
        }

        // Add the panel to the frame and show it
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(550,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void searchTeam(java.awt.event.ActionEvent evt)
    {
        this.setVisible(false);
        String teamName = JOptionPane.showInputDialog(null, "Search Team", "Team Search", JOptionPane.PLAIN_MESSAGE);
        teamName = teamName.replace(" ", "%20"); // assign the result of replace back to teamName
        teamHighlightWin = new TeamHighlights(teamName);
        teamHighlightWin.setVisible(true); 
        teamHighlightWin.setLocationRelativeTo(null);
        teamHighlightWin.HomePage(this);
    }        
    
    public void news(java.awt.event.ActionEvent evt)
    {
        List<JLabel[]> transfers = AllNews.getAllTransferNews();
       
        JFrame frame = new JFrame("Transfers");
        JPanel panel = new JPanel(new GridLayout(transfers.size(), 3));

        for (JLabel[] transfer : transfers) {
            panel.add(transfer[0]);
            panel.add(transfer[1]);
            panel.add(transfer[2]);
            panel.add(transfer[3]);
            panel.add(transfer[4]);
            panel.add(transfer[5]);
            panel.add(transfer[6]);            
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.getContentPane().add(scrollPane);

        // Add the panel to the frame and show it
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(850,1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {

        main mainPage = new main();
        mainPage.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
