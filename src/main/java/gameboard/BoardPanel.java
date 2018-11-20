package gameboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


import environment.Environment;

public class BoardPanel extends JPanel {
  private JPanel squares[][] = new JPanel[4][4];
  private Environment environment = Environment.getEnvironment(4, 4);
	
  public BoardPanel() {
    setLayout(new GridLayout(4,4));
	  for (int r = 0; r < squares.length; r++) {
      for (int c = 0; c < squares[0].length; c++) {
        squares[r][c] = new JPanel();
        squares[r][c].setBackground(Color.white);
        squares[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
        add(squares[r][c]);
        squares[r][c].setPreferredSize(new Dimension (100,100));
      }
    }
	  
	  // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Game Board"));
	}
	
	/**
	Private inner class that handles mouse events.
	When an event occurs, the text field for that
	event is given a yellow background.
	*/
	private class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}
