package gameboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import lifeform.Human;
import lifeform.LifeForm;
import environment.Cell;

public class BoardPanel extends JPanel implements FocusListener {
  private BoardCellPanel squares[][] = new BoardCellPanel[4][4];
  
  private int x; //x location on gameboard
  private int y; //y location on gameboard

  /**
   * Creates a board panel
   */
  public BoardPanel() {

    setLayout(new GridLayout(4, 4));
    for (int r = 0; r < squares.length; r++) {
      for (int c = 0; c < squares[0].length; c++) {
        squares[r][c] = new BoardCellPanel();
        squares[r][c].setBackground(Color.white);
        squares[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
        add(squares[r][c]);
        squares[r][c].setPreferredSize(new Dimension(100, 100));
      }
        /*LifeForm mina = new Human("mina", 0, 0);
        squares[2][1].add(displayHuman(mina, 2, 1));*/
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
		  x = e.getX();
      y = e.getY(); 
		  
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//setBackground(Color.yellow);
			
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
	
	public JLabel displayHuman(LifeForm entity, int row, int col) {
 
    return squares[row][col].displayHuman(entity);
    
  }

}


