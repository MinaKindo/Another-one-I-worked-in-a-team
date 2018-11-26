package gameboard;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lifeform.Human;
import lifeform.LifeForm;
import environment.Environment;
import lifeform.Human;



public class BoardCellPanel extends JPanel {
	MyMouseListener mouse = new MyMouseListener();
	private int x; //x location on gameboard
  private int y; //y location on gameboard
  private LifeForm lifeForm;
	
	public BoardCellPanel() {
	  setLayout(new GridLayout(1,1));
	  
	  addMouseListener(mouse);
	}
	
	/**
	Private inner class that handles mouse events.
	*/
	private class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		  x = e.getX();
      y = e.getY(); 
      setBackground(Color.yellow);
      
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		  setBackground(Color.green);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(Color.white);
			
		}
	}

	public JLabel displayHuman(LifeForm entity) {
	  JLabel label = new JLabel();
	  if (lifeForm != null) {
  	  ImageIcon imageIcon = new ImageIcon("C:/Users/Ismael et Mina/Desktop/SHIP/Computer Science Major/Fall 2018/"
          + "lab567-newfolder/lab567/src/main/java/gameboard/human.jpg");
      Image image = imageIcon.getImage(); // transform it 
      Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      imageIcon = new ImageIcon(newimg);  // transform it back
      label.setIcon(imageIcon);
	  }
    return label;
	  
	}
	
	public int selectedX() {
    return x;
	}

  public int selectedY() {
    return y;
  }
}
