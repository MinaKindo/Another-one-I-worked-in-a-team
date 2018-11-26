package gameboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameGui extends JFrame {

  // private WelcomePanel welcome; // Welcome Panel
  private LegendPanel legend; // A panel for the legend
  private PlayerInfoPanel playerInfo; // A panel for the player Info
  private BoardPanel board; // A panel for the board
  protected JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    GameGui window = new GameGui();
  }

  /**
   * Create the application.
   */
  public GameGui() {
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

  /**
   * Return x value of position
   * @return
   */
  public int selectedX() {
    return 0;
  }

  public int selectedY() {
    return 0;
  }

}
