import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Implements the main menu of game.
 */
public class MainMenuCard extends BaseCard implements ActionListener {
    private JButton buttonNewGame = new JButton("New Game");
    private JButton buttonLeaderBoard = new JButton("Leaderboard");
    private JButton buttonRules = new JButton("Rules");
    private JButton buttonExitGame = new JButton("Exit");
    private JLabel caption = new JLabel("MainMenu");

    public MainMenuCard() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(5, 1));
        add(caption);
        caption.setHorizontalAlignment(JLabel.CENTER);
        buttonNewGame.addActionListener(this);
        add(buttonNewGame);
        buttonLeaderBoard.addActionListener(this);
        add(buttonLeaderBoard);
        buttonRules.addActionListener(this);
        add(buttonRules);
        buttonExitGame.addActionListener(this);
        add(buttonExitGame);
        setVisible(true);
    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {

        if (event.getSource().equals(buttonNewGame)) {
            showCard(Constants.NEWGAME_CARD);
        }
        if (event.getSource().equals(buttonLeaderBoard)) {
            showCard(Constants.LEADERBOARD_CARD);
        }
        if (event.getSource().equals(buttonRules)) {
            showCard(Constants.RULES_CARD);
        }
        if (event.getSource().equals(buttonExitGame)) {
            System.exit(0);
        }
    }
}
