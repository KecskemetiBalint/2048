import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Implements the new game card. Asks for the player name.
 */
public class NewGameCard extends BaseCard implements ActionListener, ComponentListener {
    private JLabel titleLabel;
    private JButton backButton;
    private JPanel panel1;
    private JTextField playerNameText;
    private JButton startButton;

    public NewGameCard() {
        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        backButton = new JButton();
        panel1 = new JPanel();
        playerNameText = new JTextField();
        startButton = new JButton();

        setLayout(new BorderLayout());

        // ---- titleLabel ----
        titleLabel.setText("New Game");
        titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // ---- backButton ----
        backButton.setText("Back");
        backButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        backButton.addActionListener(this);
        add(backButton, BorderLayout.SOUTH);

        panel1.setLayout(new GridBagLayout());
        ((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0, 0 };
        ((GridBagLayout) panel1.getLayout()).rowWeights = new double[] { 0.0, 0.0, 1.0E-4 };

        // ---- playerNameText ----
        playerNameText.setBorder(new CompoundBorder(
                new TitledBorder("Player name"),
                new EmptyBorder(5, 5, 5, 5)));
        playerNameText.setMinimumSize(new Dimension(200, 50));
        playerNameText.addActionListener(this);
        panel1.add(playerNameText, new GridBagConstraints(0, 0, 1, 1, 2.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        // ---- startButton ----
        startButton.setText("Start");
        startButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        startButton.addActionListener(this);
        panel1.add(startButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(panel1, BorderLayout.CENTER);
        this.addComponentListener(this);
    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(backButton)) {
            showCard(Constants.MAIN_MENU_CARD);
        }
        if (event.getSource().equals(startButton) || event.getSource().equals(playerNameText)) {
            if (playerNameText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a player name!");
            } else {
                Main.gameLogic.startGame();
                Main.gameLogic.setPlayerName(playerNameText.getText());
                showCard(Constants.GAME_CARD);
            }

        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
        playerNameText.requestFocus();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}