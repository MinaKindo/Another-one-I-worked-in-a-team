package gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import environment.Environment;
import lifeform.LifeForm;

public class GameGUI extends JFrame {

	//private WelcomePanel welcome; // Welcome Panel
	private LegendPanel legend; //A panel for the legend
	private PlayerInfoPanel playerInfo; //A panel for the player Info
	private BoardPanel board; //A panel for the board
    protected JFrame frame;
    private int x; //x location on gameboard
    private int y; //y location on gameboard
    private Environment environment = Environment.getEnvironment(4, 4); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	  GameGUI window = new GameGUI();
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	// Create a BorderLayout manager.
    setLayout(new BorderLayout());
    setSize(1300, 800);
    legend = new LegendPanel();
    playerInfo = new PlayerInfoPanel();
    board = new BoardPanel();
    
    // Add the components to the content pane.
    add(board, BorderLayout.WEST);
    add(legend, BorderLayout.EAST);
    add(playerInfo, BorderLayout.SOUTH);
    addMouseListener(new MyMouseListener());
    
    // Pack the contents of the window and display it.
    pack();
    setVisible(true);
    
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1000, 1000, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int selectedX() {
    return x;
  }

  public int selectedY() {
    return y;
  }
  
  /**
	Private inner class that handles mouse events.
	*/
	private class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();			
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
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(Color.white);
			
		}
	}
	
	public JLabel displayHuman(LifeForm entity, int row, int col) {
	  
    return board.displayHuman(entity, row, col);
    
  }

}
