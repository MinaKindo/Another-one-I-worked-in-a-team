package command;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameboard.GameGUI;

public class InvokerUI extends JFrame implements ActionListener {

  private JButton reloadButton;
  private JButton northButton;
  private JButton westButton;
  private JButton eastButton;
  private JButton southButton;
  private JButton moveButton;
  private JButton attackButton;
  private JButton dropButton;
  private JButton acquireButton;

  private GameGUI gameGUI;

  private Command reloadCommand = new ReloadCommand();
  private Command northCommand = new NorthCommand();
  private Command westCommand = new WestCommand();
  private Command eastCommand = new EastCommand();
  private Command southCommand = new SouthCommand();
  private Command moveCommand = new MoveCommand();
  private Command attackCommand = new AttackCommand();
  private Command dropCommand = new DropCommand();
  private Command acquireCommand = new AcquireCommand();

  public InvokerUI(GameGUI gameGUI) {
    this.gameGUI = gameGUI;
    this.setTitle("commands");
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    Font font = new Font("SansSerif", Font.PLAIN, 20);
    JLabel text = new JLabel("Choose an action");
    text.setFont(font);
    text.setHorizontalAlignment(JLabel.CENTER);
    this.add(text, BorderLayout.NORTH);

    // buttons
    JPanel buttons = new JPanel();
    buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttons.setLayout(new GridLayout(2, 3, 10, 10));

    reloadButton = new JButton("RELOAD");
    buttons.add(reloadButton);

    // directional buttons
    JPanel directionalButtons = new JPanel();
    directionalButtons.setLayout(new GridLayout(3, 3));

    directionalButtons.add(new JPanel());

    northButton = new JButton("NORTH");
    directionalButtons.add(northButton);

    directionalButtons.add(new JPanel());

    westButton = new JButton("WEST");
    directionalButtons.add(westButton);

    directionalButtons.add(new JPanel());

    eastButton = new JButton("EAST");
    directionalButtons.add(eastButton);

    directionalButtons.add(new JPanel());

    southButton = new JButton("SOUTH");
    directionalButtons.add(southButton);

    directionalButtons.add(new JPanel());

    buttons.add(directionalButtons);

    moveButton = new JButton("MOVE");
    buttons.add(moveButton);
    attackButton = new JButton("ATTACK");
    buttons.add(attackButton);
    dropButton = new JButton("DROP");
    buttons.add(dropButton);
    acquireButton = new JButton("ACQUIRE");
    buttons.add(acquireButton);

    // button listeners
    reloadButton.addActionListener(this);
    northButton.addActionListener(this);
    westButton.addActionListener(this);
    eastButton.addActionListener(this);
    southButton.addActionListener(this);
    moveButton.addActionListener(this);
    attackButton.addActionListener(this);
    dropButton.addActionListener(this);
    acquireButton.addActionListener(this);

    this.add(buttons, BorderLayout.SOUTH);
    this.pack();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == reloadButton) {
      reloadCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == northButton) {
      northCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == westButton) {
      westCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == eastButton) {
      eastCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == southButton) {
      southCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == moveButton) {
      moveCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == attackButton) {
      attackCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == dropButton) {
      dropCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    } else if (e.getSource() == acquireButton) {
      acquireCommand.execute(gameGUI.selectedX(), gameGUI.selectedY());
    }
  }
}
