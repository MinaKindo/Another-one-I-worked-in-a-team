package gameboard;

import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel {
  public LegendPanel() {
    setLayout(new GridLayout(9,1));
    // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Legend"));
    ImageIcon human = new ImageIcon("human.jpg");
    JLabel humanMsg = new JLabel("   Represents a human");
    humanMsg.setIcon(human);
    
    ImageIcon alien = new ImageIcon("alien.jpg");
    JLabel alienMsg = new JLabel("   Represents an alien");
    alienMsg.setIcon(alien);
    
    //add legend
    add(humanMsg);
    add(alienMsg);
  }

}
