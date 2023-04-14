
package com.mycompany.soccermatchupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class TeamHighlights extends javax.swing.JFrame {
    private main mainWindow;
    
    List<JLabel[]> myTeamGames;
    List<JLabel[]> mySquad;
    List<JLabel[]> myStanding;
    private String teamName;
    private JPanel gameLabelsPanel;
    

   
    public TeamHighlights(String teamName) {
        this.teamName = teamName;
        this.myStanding = myTeam.getTeamsStandings(teamName);
        this.myTeamGames = myTeam.getMyTeamLabel(teamName);
        this.mySquad = myTeam.getSquad(teamName);
        gameComponents();
    }

    private void updateComponents(String newTeamName) {
        this.teamName = newTeamName;
        gameComponents();
    }
    private void gameComponents() {
    JPanel panel = new JPanel();

    JButton chosenTeamSquad = new javax.swing.JButton();
    chosenTeamSquad.setText("Squad");
    chosenTeamSquad.setBounds(400, 0, 150, 70);
    chosenTeamSquad.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            chosenTeamSquad(evt);
        }
    });

    JButton standing = new javax.swing.JButton();
    standing.setText("Standing");
    standing.setBounds(320, 0, 150, 70);
    standing.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            standing(evt);
        }
    });
    
    JButton searchTeam = new javax.swing.JButton();
    searchTeam.setText(" Search Team");
    searchTeam.setBounds(240, 0, 150, 70);
    searchTeam.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            searchTeam(evt);
        }
    });

    gameLabelsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
    gameLabelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    for (int i = 0; i < myTeamGames.size(); i++) {
        JLabel[] gameLabels = myTeamGames.get(i);
        JPanel gamePanel = new JPanel();
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        gamePanel.setBackground(Color.WHITE);
        for (int j = 0; j < gameLabels.length; j++) {
            gamePanel.add(gameLabels[j]);
        }
        gameLabelsPanel.add(gamePanel);
    }

    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
    buttonPanel.add(chosenTeamSquad);
    buttonPanel.add(standing);
    buttonPanel.add(searchTeam);
    gameLabelsPanel.add(buttonPanel);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void HomePage(main homePage){
        mainWindow = homePage;
    }
    
    private void chosenTeamSquad(java.awt.event.ActionEvent evt) {
        mySquad = myTeam.getSquad(teamName);
        JPanel panel = new JPanel(new GridLayout(mySquad.size(), 5));
        for (JLabel[] playerTable : mySquad) {
            for (JLabel label : playerTable) {
                panel.add(label);
            }
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        JFrame frame = new JFrame("Squad");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(800,700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void standing(java.awt.event.ActionEvent evt) {
        myStanding = myTeam.getTeamsStandings(teamName);
        JPanel panel = new JPanel(new GridLayout(myStanding.size(), 5));

        int counter = 0;
        for (JLabel[] StandingTable : myStanding) {
            for (JLabel label : StandingTable) {
                if (counter % 2 == 0) {
                    label.setBackground(Color.GRAY);
                } else {
                    label.setBackground(Color.DARK_GRAY);
                }
                label.setOpaque(true);
                panel.add(label);
            }
            counter++;
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        JFrame frame = new JFrame("Standing");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(800,700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void searchTeam(java.awt.event.ActionEvent evt) {
       String teamName = JOptionPane.showInputDialog("Enter team name:");
       teamName = teamName.replace(" ", "%20"); // assign the result of replace back to teamName
       if (teamName != null && !teamName.isEmpty()) {
           updateComponents(teamName);
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
