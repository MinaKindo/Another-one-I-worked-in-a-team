package gameboard;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.Human;
import lifeform.LifeForm;

public class MockGUI {
  public static void main(String[] args) {
    GameGUI window = new GameGUI();
    LifeForm mina = new Human("mina", 0, 0);
    window.displayHuman(mina, 2, 1);
  }
}
