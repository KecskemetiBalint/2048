import java.awt.*;
import javax.swing.*;

/**
 * 2048 CBL game.
 * 
 * @author Bálint Kecskeméti
 * @author Botond Mecsei
 *
 */
public class Main {
    public static GameLogic gameLogic = new GameLogic();
    public static LeaderBoard leaderBoard = new LeaderBoard();

    public static void main(String[] args) {
        JPanel cardContainer = new JPanel(new CardLayout());

        cardContainer.add(new MainMenuCard(), Constants.MAIN_MENU_CARD);
        cardContainer.add(new RulesCard(), Constants.RULES_CARD);
        cardContainer.add(new LeaderBoardCard(), Constants.LEADERBOARD_CARD);
        cardContainer.add(new NewGameCard(), Constants.NEWGAME_CARD);
        cardContainer.add(new GameCard(), Constants.GAME_CARD);
        cardContainer.add(new EndGameCard(), Constants.ENDGAME_CARD);

        JFrame window = new JFrame("2048");
        window.setMinimumSize(new Dimension(400, 600));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(cardContainer);
        window.setVisible(true);
        ((CardLayout) cardContainer.getLayout()).show(cardContainer, Constants.MAIN_MENU_CARD);
        return;
    }
}
