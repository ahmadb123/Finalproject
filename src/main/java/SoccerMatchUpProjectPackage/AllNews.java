
package SoccerMatchUpProjectPackage;

import static SoccerMatchUpProjectPackage.AllGames.getScaledIcon;
import ApiPackage.RecentTransfersApi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AllNews {
    public static List<JLabel[]> getAllTransferNews()
    {
        List<JLabel[]> allTransfersLabel = new ArrayList<>();
        RecentTransfersApi response = RecentTransfersApi.recentTransfers();
        for(int i = 0; i < response.data.length; i++)
        {
            String transferName = response.data[i].getPlayerInfo().getTransferName();
            ImageIcon transferImage = getScaledIcon(response.data[i].getPlayerInfo().getTransferImage());
            String fromTeam = response.data[i].getFromTeamInfo().getFromTeamName();
            ImageIcon fromTeamIcon = getScaledIcon(response.data[i].getFromTeamInfo().getFromTeamIcon());
            String toTeam = response.data[i].getToTeamInfo().getToTeamName();
            ImageIcon toTeamIcon = getScaledIcon(response.data[i].getToTeamInfo().getToTeamIcon());
            JLabel[] transferLabel = new JLabel[] { 
                new JLabel(transferName),
                new JLabel(transferImage),
                new JLabel(fromTeam),
                new JLabel(fromTeamIcon),
                new JLabel(" " + " --> "),
                new JLabel(toTeamIcon),
                new JLabel(toTeam)
            };
            allTransfersLabel.add(transferLabel);
        }
        return allTransfersLabel;
    }
}
