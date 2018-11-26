package gameboard;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LegendPanel extends JPanel {
  
  /**
   * Creates a legend panel
   */
  public LegendPanel() {
    setLayout(new GridLayout(9, 1));
    // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Legend"));
    
    
    JLabel human = createLabel("human", "/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/"
    		+ "lab567/src/main/java/gameboard/human.jpg");
    JLabel alien = createLabel("alien", "/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/"
    		+ "lab567/src/main/java/gameboard/alien.jpg");
    JLabel chainGun = createLabel("chain gun", "/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/"
    		+ "lab567/src/main/java/gameboard/ChainGun.png");
    JLabel pistol = createLabel("pistol", "/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/"
    		+ "lab567/src/main/java/gameboard/pistol.jpg");
    JLabel plasmaCannon = createLabel("plasma cannon", "/home/aa1184/Fall2018/swe200/labs/lab567-newfolder/"
    		+ "lab567/src/main/java/gameboard/plasmaCannon.png");
    JLabel north = new JLabel("N    North");
    JLabel south = new JLabel("S    South");
    JLabel east = new JLabel("E    East");
    JLabel west = new JLabel("W    West");
    
    
    //add legend
    add(human);
    add(alien);
    add(pistol);
    add(chainGun);
    add(plasmaCannon);
    add(north);
    add(south);
    add(east);
    add(west);
    
  }
  
  public JLabel createLabel(String type, String imgLocation) {
	JLabel label = new JLabel("   Represents a " + type);  
	ImageIcon imageIcon = new ImageIcon(imgLocation);
    Image image = imageIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    imageIcon = new ImageIcon(newimg);  // transform it back
    label.setIcon(imageIcon);

	return label;
  }
  
  
  
  
  

}
