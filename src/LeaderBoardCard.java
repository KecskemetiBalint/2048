import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Implements the leaderboard screen with a table.
 */
public class LeaderBoardCard extends BaseCard implements ActionListener, ComponentListener {

    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private JTable leaderBoard;
    private JButton backButton;

    public LeaderBoardCard() {
        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        scrollPane = new JScrollPane();
        leaderBoard = new JTable();
        backButton = new JButton();

        setLayout(new BorderLayout());

        // ---- titleLabel ----
        titleLabel.setText("Leaderboard (Top 30 ever!)");
        titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        scrollPane.setViewportView(leaderBoard);

        add(scrollPane, BorderLayout.CENTER);

        // ---- backButton ----
        backButton.setText("Back");
        backButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        backButton.addActionListener(this);
        add(backButton, BorderLayout.SOUTH);
        this.addComponentListener(this);

    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(backButton)) {
            showCard(Constants.MAIN_MENU_CARD);
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
        updateScreen();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    private void updateScreen() {
        leaderBoard.setModel(new DefaultTableModel(getPlayers(),
                new String[] { "Rank", "Name", "Points" }) {
            Class<?>[] columnTypes = new Class<?>[] { String.class, String.class, Integer.class };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        leaderBoard.getTableHeader().setReorderingAllowed(false);

    }

    private Object[][] getPlayers() {
        ArrayList<LeaderBoardEntry> players = Main.leaderBoard.getPlayers();
        Object[][] cells = new Object[players.size()][];
        for (int i = 0; i < players.size(); i++) {
            cells[i] = new String[] { String.format("%d.", i + 1),
                    players.get(i).getPlayerName(),
                    String.format("%d", players.get(i).getPoints()) };
        }
        return cells;
    }

}
