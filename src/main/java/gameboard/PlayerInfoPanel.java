package gameboard;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerInfoPanel extends JPanel {
  
  /**
   * Creates a player info panel
   */
  public PlayerInfoPanel() {
    setLayout(new GridLayout(1, 1));
    // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Player Info"));
  }

}
