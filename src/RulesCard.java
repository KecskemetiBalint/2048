import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Implements the rules screen.
 */
public class RulesCard extends BaseCard implements ActionListener {
    private JLabel titleLabel;
    private JButton backButton;
    private JTextArea rulesText;

    public RulesCard() {
        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        backButton = new JButton();
        rulesText = new JTextArea();

        setLayout(new BorderLayout());

        // ---- titleLabel ----
        titleLabel.setText("Rules");
        titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // ---- backButton ----
        backButton.setText("Back");
        backButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        backButton.addActionListener(this);
        add(backButton, BorderLayout.SOUTH);

        // ---- rulesText ----
        rulesText.setEditable(false);
        rulesText.setText(
                "In 2048 the player must combine tiles that contain the same number. "
                        + "In every tile there are integers that are a power of two. Two tiles can "
                        + "be combined when contain the number, and combining them equals a single"
                        + " tile that contains the sum of the two previous ones. The goal is to "
                        + "reach a tile that contains the number 2048, but the game goes until "
                        + "there are no more possibilities to combine tiles.");
        rulesText.setLineWrap(true);
        rulesText.setWrapStyleWord(true);
        add(rulesText, BorderLayout.CENTER);
    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(backButton)) {
            showCard(Constants.MAIN_MENU_CARD);
        }
    }
}
