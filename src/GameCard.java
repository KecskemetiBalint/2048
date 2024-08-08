import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 * Implements the main game screen with tiles, actual ponints
 * and game flow.
 */
public class GameCard extends BaseCard implements ActionListener, ComponentListener {
    private JPanel topPanel;
    private JButton endGameButton;
    private JLabel pointLabel;
    private JPanel panel1;
    private JLabel tile00;
    private JLabel tile01;
    private JLabel tile02;
    private JLabel tile03;
    private JLabel tile10;
    private JLabel tile11;
    private JLabel tile12;
    private JLabel tile13;
    private JLabel tile20;
    private JLabel tile21;
    private JLabel tile22;
    private JLabel tile23;
    private JLabel tile30;
    private JLabel tile31;
    private JLabel tile32;
    private JLabel tile33;

    public GameCard() {
        initComponents();
    }

    private void updateScreen() {
        tile00.setOpaque(false);
        tile01.setOpaque(false);
        tile02.setOpaque(false);
        tile03.setOpaque(false);
        tile10.setOpaque(false);
        tile11.setOpaque(false);
        tile12.setOpaque(false);
        tile13.setOpaque(false);
        tile20.setOpaque(false);
        tile21.setOpaque(false);
        tile22.setOpaque(false);
        tile23.setOpaque(false);
        tile30.setOpaque(false);
        tile31.setOpaque(false);
        tile32.setOpaque(false);
        tile33.setOpaque(false);

        this.updateUI();

        tile00.setOpaque(true);
        tile01.setOpaque(true);
        tile02.setOpaque(true);
        tile03.setOpaque(true);
        tile10.setOpaque(true);
        tile11.setOpaque(true);
        tile12.setOpaque(true);
        tile13.setOpaque(true);
        tile20.setOpaque(true);
        tile21.setOpaque(true);
        tile22.setOpaque(true);
        tile23.setOpaque(true);
        tile30.setOpaque(true);
        tile31.setOpaque(true);
        tile32.setOpaque(true);
        tile33.setOpaque(true);

        tile00.setBackground(Main.gameLogic.getTileColor(0, 0));
        tile01.setBackground(Main.gameLogic.getTileColor(0, 1));
        tile02.setBackground(Main.gameLogic.getTileColor(0, 2));
        tile03.setBackground(Main.gameLogic.getTileColor(0, 3));
        tile10.setBackground(Main.gameLogic.getTileColor(1, 0));
        tile11.setBackground(Main.gameLogic.getTileColor(1, 1));
        tile12.setBackground(Main.gameLogic.getTileColor(1, 2));
        tile13.setBackground(Main.gameLogic.getTileColor(1, 3));
        tile20.setBackground(Main.gameLogic.getTileColor(2, 0));
        tile21.setBackground(Main.gameLogic.getTileColor(2, 1));
        tile22.setBackground(Main.gameLogic.getTileColor(2, 2));
        tile23.setBackground(Main.gameLogic.getTileColor(2, 3));
        tile30.setBackground(Main.gameLogic.getTileColor(3, 0));
        tile31.setBackground(Main.gameLogic.getTileColor(3, 1));
        tile32.setBackground(Main.gameLogic.getTileColor(3, 2));
        tile33.setBackground(Main.gameLogic.getTileColor(3, 3));

        tile00.setText(Main.gameLogic.getTileValue(0, 0));
        tile01.setText(Main.gameLogic.getTileValue(0, 1));
        tile02.setText(Main.gameLogic.getTileValue(0, 2));
        tile03.setText(Main.gameLogic.getTileValue(0, 3));
        tile10.setText(Main.gameLogic.getTileValue(1, 0));
        tile11.setText(Main.gameLogic.getTileValue(1, 1));
        tile12.setText(Main.gameLogic.getTileValue(1, 2));
        tile13.setText(Main.gameLogic.getTileValue(1, 3));
        tile20.setText(Main.gameLogic.getTileValue(2, 0));
        tile21.setText(Main.gameLogic.getTileValue(2, 1));
        tile22.setText(Main.gameLogic.getTileValue(2, 2));
        tile23.setText(Main.gameLogic.getTileValue(2, 3));
        tile30.setText(Main.gameLogic.getTileValue(3, 0));
        tile31.setText(Main.gameLogic.getTileValue(3, 1));
        tile32.setText(Main.gameLogic.getTileValue(3, 2));
        tile33.setText(Main.gameLogic.getTileValue(3, 3));
        pointLabel.setText(String.format("POINTS: %d", Main.gameLogic.getScore()));

    }

    private void initComponents() {
        topPanel = new JPanel();
        endGameButton = new JButton();
        pointLabel = new JLabel();
        panel1 = new JPanel();
        tile00 = new JLabel();
        tile01 = new JLabel();
        tile02 = new JLabel();
        tile03 = new JLabel();
        tile10 = new JLabel();
        tile11 = new JLabel();
        tile12 = new JLabel();
        tile13 = new JLabel();
        tile20 = new JLabel();
        tile21 = new JLabel();
        tile22 = new JLabel();
        tile23 = new JLabel();
        tile30 = new JLabel();
        tile31 = new JLabel();
        tile32 = new JLabel();
        tile33 = new JLabel();

        setLayout(new BorderLayout());

        topPanel.setLayout(new GridLayout(1, 2));

        // ---- backButton ----
        endGameButton.setText("End Game");
        endGameButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        endGameButton.setMinimumSize(new Dimension(64, 50));
        endGameButton.setMaximumSize(new Dimension(64, 50));
        endGameButton.addActionListener(this);

        topPanel.add(endGameButton);

        // ---- pointLabel ----
        pointLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        topPanel.add(pointLabel);
        add(topPanel, BorderLayout.NORTH);

        // ======== panel1 ========
        panel1.setBackground(new Color(0xccffff));
        panel1.setLayout(new GridLayout(4, 4));

        // ---- tile00 ----
        tile00.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile00.setAutoscrolls(true);
        tile00.setHorizontalAlignment(SwingConstants.CENTER);
        tile00.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile00);

        // ---- tile01 ----
        tile01.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile01.setAutoscrolls(true);
        tile01.setHorizontalAlignment(SwingConstants.CENTER);
        tile01.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile01);

        // ---- tile02 ----
        tile02.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile02.setAutoscrolls(true);
        tile02.setHorizontalAlignment(SwingConstants.CENTER);
        tile02.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile02);

        // ---- tile03 ----
        tile03.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile03.setAutoscrolls(true);
        tile03.setHorizontalAlignment(SwingConstants.CENTER);
        tile03.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile03);

        // ---- tile10 ----
        tile10.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile10.setAutoscrolls(true);
        tile10.setHorizontalAlignment(SwingConstants.CENTER);
        tile10.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile10);

        // ---- tile11 ----
        tile11.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile11.setAutoscrolls(true);
        tile11.setHorizontalAlignment(SwingConstants.CENTER);
        tile11.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile11);

        // ---- tile12 ----
        tile12.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile12.setAutoscrolls(true);
        tile12.setHorizontalAlignment(SwingConstants.CENTER);
        tile12.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile12);

        // ---- tile13 ----
        tile13.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile13.setAutoscrolls(true);
        tile13.setHorizontalAlignment(SwingConstants.CENTER);
        tile13.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile13);

        // ---- tile20 ----
        tile20.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile20.setAutoscrolls(true);
        tile20.setHorizontalAlignment(SwingConstants.CENTER);
        tile20.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile20);

        // ---- tile21 ----
        tile21.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile21.setAutoscrolls(true);
        tile21.setHorizontalAlignment(SwingConstants.CENTER);
        tile21.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile21);

        // ---- tile22 ----
        tile22.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile22.setAutoscrolls(true);
        tile22.setHorizontalAlignment(SwingConstants.CENTER);
        tile22.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile22);

        // ---- tile23 ----
        tile23.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile23.setAutoscrolls(true);
        tile23.setHorizontalAlignment(SwingConstants.CENTER);
        tile23.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile23);

        // ---- tile30 ----
        tile30.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile30.setAutoscrolls(true);
        tile30.setHorizontalAlignment(SwingConstants.CENTER);
        tile30.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile30);

        // ---- tile31 ----
        tile31.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile31.setAutoscrolls(true);
        tile31.setHorizontalAlignment(SwingConstants.CENTER);
        tile31.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile31);

        // ---- tile32 ----
        tile32.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile32.setAutoscrolls(true);
        tile32.setHorizontalAlignment(SwingConstants.CENTER);
        tile32.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile32);

        // ---- tile33 ----
        tile33.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tile33.setAutoscrolls(true);
        tile33.setHorizontalAlignment(SwingConstants.CENTER);
        tile33.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panel1.add(tile33);
        add(panel1, BorderLayout.CENTER);

        this.addComponentListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), RIGHT);
        this.getActionMap().put(RIGHT, right);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), LEFT);
        this.getActionMap().put(LEFT, left);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), UP);
        this.getActionMap().put(UP, up);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), DOWN);
        this.getActionMap().put(DOWN, down);
    }

    /**
     * Event handler for buttons on the screen.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(endGameButton)) {
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
        updateScreen();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    private static final String RIGHT = "Right";

    private Action right = new AbstractAction(RIGHT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.gameLogic.moveRight(false);
            handleAction();
        }
    };

    private static final String LEFT = "Left";

    private Action left = new AbstractAction(LEFT) {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.gameLogic.moveLeft(false);
            handleAction();
        }
    };

    private static final String UP = "Up";

    private Action up = new AbstractAction(UP) {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.gameLogic.moveUp(false);
            handleAction();
        }
    };

    private static final String DOWN = "Down";

    private Action down = new AbstractAction(DOWN) {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.gameLogic.moveDown(false);
            handleAction();
        }
    };

    /**
     * Handles the game flow and arrow buttons.
     */
    private void handleAction() {
        updateScreen();
        if (!Main.gameLogic.canGameGoOn()) {
            Main.leaderBoard.addPlayer(Main.gameLogic.getPlayerName(), Main.gameLogic.getScore());
            showCard(Constants.ENDGAME_CARD);
        }
    }
}