import java.awt.*;
import javax.swing.*;

/**
 * Base Panel for all shown panel in the cardlayout.
 */
public class BaseCard extends JPanel {

    public void showCard(String cardName) {
        ((CardLayout) getParent().getLayout()).show(getParent(), cardName);
    }
}
