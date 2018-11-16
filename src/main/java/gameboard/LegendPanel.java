package gameboard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LegendPanel extends JPanel {
  public LegendPanel() {
    setLayout(new GridLayout(9,1));
    // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Legend"));
    
    ImageIcon humanIcon = new ImageIcon("/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/lab567/src/main/java/gameboard/human.jpg");
    JLabel humanMsg = new JLabel("   Represents a human");
    humanMsg.setIcon(fixImage(humanIcon));
    
    ImageIcon alien = new ImageIcon("alien.jpg");
    JLabel alienMsg = new JLabel("   Represents an alien");
    alienMsg.setIcon(alien);
    
    //add legend
    add(humanMsg);
    add(alienMsg);
    
    
  }
  
  private ImageIcon fixImage(ImageIcon imageIcon) {
    Image image = imageIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    imageIcon = new ImageIcon(newimg);  // transform it back

    return imageIcon;
}
  
  

}
