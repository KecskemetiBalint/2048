import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Implements the screen shown when the game is over. It's shows the player
 * name, the points earned
 * and position on the leaderboard.
 */
public class EndGameCard extends BaseCard implements ActionListener, ComponentListener {
    private JPanel panel1;
    private JButton buttonNewGame;
    private JButton buttonHome;
    private JScrollPane scrollPane1;
    private JTextPane messagePanel;
    private JLabel titleLabel;

    public EndGameCard() {
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        buttonNewGame = new JButton();
        buttonHome = new JButton();
        scrollPane1 = new JScrollPane();
        messagePanel = new JTextPane();
        titleLabel = new JLabel();

        setLayout(new BorderLayout());

        panel1.setLayout(new GridLayout(2, 1));

        messagePanel.setEditable(false);

        // ---- buttonNewGame ----
        buttonNewGame.setText("New game");
        buttonNewGame.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonNewGame.addActionListener(this);
        panel1.add(buttonNewGame);

        // ---- buttonHome ----
        buttonHome.setText("Home");
        buttonHome.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonHome.addActionListener(this);
        panel1.add(buttonHome);
        add(panel1, BorderLayout.SOUTH);

        // ======== scrollPane1 ========

        // ---- messagePanel ----
        scrollPane1.setViewportView(messagePanel);
        add(scrollPane1, BorderLayout.CENTER);

        // ---- titleLabel ----
        titleLabel.setText("End game");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(titleLabel, BorderLayout.NORTH);

        this.addComponentListener(this);
    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(buttonNewGame)) {
            Main.gameLogic.startGame();
            showCard(Constants.GAME_CARD);
        }
        if (event.getSource().equals(buttonHome)) {
            showCard(Constants.MAIN_MENU_CARD);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    /**
     * Event handler for component shown event.
     */
    @Override
    public void componentShown(ComponentEvent e) {
        messagePanel.setText("Congratulations " + Main.gameLogic.getPlayerName()
                + "!\n" + "Your score is: "
                + String.format("%d", Main.gameLogic.getScore()) + "!\n"
                + "You gained the "
                + String.format("%d.",
                        Main.leaderBoard.getPositionOfPlayer(
                                Main.gameLogic.getPlayerName(),
                                Main.gameLogic.getScore()))
                + " position on the leaderboard!");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
