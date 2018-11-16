package gameboard;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


import environment.Cell;

public class BoardPanel extends JPanel {
	JPanel squares[][] = new JPanel[10][10];
	
	public BoardPanel() {
	  
	  setLayout(new GridLayout(10,10));
	  for (int r = 0; r < squares.length; r++) {
      for (int c = 0; c < squares[0].length; c++) {
        squares[r][c] = new JPanel();
        squares[r][c].setBackground(Color.white);
        squares[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
        add(squares[r][c]);
      }
    }
	  
	  // Add a border around the panel.
    setBorder(BorderFactory.createTitledBorder("Game Board"));
	}
}
